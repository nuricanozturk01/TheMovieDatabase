package nuricanozturk.dev.movie.get.service.api.service;

import nuricanozturk.dev.movie.get.service.api.entity.MovieDetails;
import nuricanozturk.dev.movie.get.service.api.entity.MoviesRoot;
import nuricanozturk.dev.movie.get.service.config.MappersConfig;
import nuricanozturk.dev.movie.get.service.config.UrlConfig;
import nuricanozturk.dev.movie.get.service.dto.MovieDetailStringDTO;
import nuricanozturk.dev.movie.get.service.dto.MovieWithDetailStringDTO;
import nuricanozturk.dev.movie.get.service.dto.MoviesDTO;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

import static java.lang.String.format;

@Service
@Scope("prototype")
public class MovieSearchService
{
    private final RestTemplate m_restTemplate;
    private final MappersConfig m_mappersConfig;
    private final UrlConfig m_urlConfig;

    public MovieSearchService(RestTemplate restTemplate, MappersConfig mappersConfig, UrlConfig urlConfig)
    {
        m_restTemplate = restTemplate;
        m_mappersConfig = mappersConfig;
        m_urlConfig = urlConfig;
    }

    public MoviesDTO getMovies(int page)
    {
        var root = Objects.requireNonNull(m_restTemplate.<MoviesRoot>getForObject(format(m_urlConfig.allMoviesUrl, page), MoviesRoot.class));

        return m_mappersConfig.m_movieMapper.toMoviesDTO(m_mappersConfig.m_movieMapper.toMovieDTO(root.results));
    }

    public MovieDetailStringDTO getMovieDetails(int movieId)
    {
        var root = m_restTemplate.getForObject(format(m_urlConfig.movieDetailsUrl, movieId), MovieDetails.class);
        var productionCompanies = m_mappersConfig.m_productionCompanyMapper.toProductionCompanyStringDTO(m_mappersConfig.m_productionCompanyMapper.toProductionCompanyDTO(Objects.requireNonNull(root).production_companies));
        var productionCountries = m_mappersConfig.m_productionCountryMapper.toProductionCountryStringDTO(m_mappersConfig.m_productionCountryMapper.toProductionCountryDTO(Objects.requireNonNull(root).production_countries));
        var genres = m_mappersConfig.m_genreMapper.toGenresStringDTO(m_mappersConfig.m_genreMapper.toGenreDTOList(Objects.requireNonNull(root).genres));

        return m_mappersConfig.m_movieDetailMapper.toMovieDetailsStringDTO(root, productionCompanies, productionCountries, genres);
    }

    public MoviesDTO getPopularMovies(int page)
    {
        var root = Objects.requireNonNull(m_restTemplate.<MoviesRoot>getForObject(format(m_urlConfig.popularMoviesUrl, page), MoviesRoot.class));
        return m_mappersConfig.m_movieMapper.toMoviesDTO(m_mappersConfig.m_movieMapper.toMovieDTO(root.results));
    }

    public MoviesDTO getMoviesByTitle(String movie)
    {
        var root = m_restTemplate.getForObject(format(m_urlConfig.searchMoviesUrl, movie.replace(" ", "%20")), MoviesRoot.class);
        return m_mappersConfig.m_movieMapper.toMoviesDTO(m_mappersConfig.m_movieMapper.toMovieDTO(Objects.requireNonNull(root).results));
    }


    public MoviesDTO getTrendingMoviesWeekly()
    {
        var root = Objects.requireNonNull(m_restTemplate.<MoviesRoot>getForObject(m_urlConfig.trendingMoviesWeeklyUrl, MoviesRoot.class));
        return m_mappersConfig.m_movieMapper.toMoviesDTO(m_mappersConfig.m_movieMapper.toMovieDTO(root.results));
    }

    public MoviesDTO getTrendingMoviesDaily()
    {
        var root = Objects.requireNonNull(m_restTemplate.<MoviesRoot>getForObject(m_urlConfig.trendingMoviesDailyUrl, MoviesRoot.class));

        return m_mappersConfig.m_movieMapper.toMoviesDTO(m_mappersConfig.m_movieMapper.toMovieDTO(root.results));
    }

    public MoviesDTO getTopRatedMovies(int page)
    {
        var root = Objects.requireNonNull(m_restTemplate.<MoviesRoot>getForObject(format(m_urlConfig.topRatedMoviesUrl, page), MoviesRoot.class));

        return m_mappersConfig.m_movieMapper.toMoviesDTO(m_mappersConfig.m_movieMapper.toMovieDTO(root.results));
    }

    public MovieWithDetailStringDTO getMovieWithDetails(int id)
    {
        var root = m_restTemplate.getForObject(format(m_urlConfig.movieDetailsUrl, id), MovieDetails.class);
        var productionCompanies = m_mappersConfig.m_productionCompanyMapper.toProductionCompanyStringDTO(m_mappersConfig.m_productionCompanyMapper.toProductionCompanyDTO(Objects.requireNonNull(root).production_companies));
        var productionCountries = m_mappersConfig.m_productionCountryMapper.toProductionCountryStringDTO(m_mappersConfig.m_productionCountryMapper.toProductionCountryDTO(Objects.requireNonNull(root).production_countries));
        var genres = m_mappersConfig.m_genreMapper.toGenresStringDTO(m_mappersConfig.m_genreMapper.toGenreDTOList(Objects.requireNonNull(root).genres));

        return m_mappersConfig.m_movieDetailMapper.toMovieWithDetailsStringDTO(root, productionCompanies, productionCountries, genres);
    }
}
