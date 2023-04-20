package nuricanozturk.dev.movie.get.service.api.service;

import nuricanozturk.dev.movie.get.service.api.entity.MovieDetails;
import nuricanozturk.dev.movie.get.service.api.entity.Root;
import nuricanozturk.dev.movie.get.service.dto.MovieDetailDTO;
import nuricanozturk.dev.movie.get.service.dto.MovieDetailStringDTO;
import nuricanozturk.dev.movie.get.service.dto.MoviesDTO;
import nuricanozturk.dev.movie.get.service.mapper.*;
import org.springframework.beans.factory.annotation.Value;
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
    private final IMovieMapper m_movieMapper;
    private final IMovieDetailMapper m_movieDetailMapper;
    private final IProductionCompanyMapper m_productionCompanyMapper;
    private final IProductionCountryMapper m_productionCountryMapper;
    private final IGenreMapper m_genreMapper;

    @Value("${tmdb.results.all.url}")
    private String allMoviesUrl;

    @Value("${tmdb.results.details.url}")
    private String movieDetailsUrl;

    @Value("${tmdb.results.popular.url}")
    private String popularMoviesUrl;

    @Value("${tmdb.results.search.url}")
    private String searchMoviesUrl;

    public MovieSearchService(RestTemplate restTemplate, IMovieMapper movieMapper, IMovieDetailMapper movieDetailMapper, IProductionCompanyMapper productionCompanyMapper, IProductionCountryMapper productionCountryMapper, IGenreMapper genreMapper)
    {
        m_restTemplate = restTemplate;
        m_movieMapper = movieMapper;
        m_movieDetailMapper = movieDetailMapper;
        m_productionCompanyMapper = productionCompanyMapper;
        m_productionCountryMapper = productionCountryMapper;
        m_genreMapper = genreMapper;
    }

    public MoviesDTO getMovies(int page)
    {
        var root = Objects.requireNonNull(m_restTemplate.<Root>getForObject(format(allMoviesUrl, page), Root.class));

        return m_movieMapper.toMoviesDTO(m_movieMapper.toMovieDTO(root.results));
    }

    public MovieDetailStringDTO getMovieDetails(int movieId)
    {
        var root = m_restTemplate.getForObject(format(movieDetailsUrl, movieId), MovieDetails.class);
        var productionCompanies = m_productionCompanyMapper.toProductionCompanyStringDTO(m_productionCompanyMapper.toProductionCompanyDTO(Objects.requireNonNull(root).production_companies));
        var productionCountries = m_productionCountryMapper.toProductionCountryStringDTO(m_productionCountryMapper.toProductionCountryDTO(Objects.requireNonNull(root).production_countries));
        var genres = m_genreMapper.toGenresStringDTO(m_genreMapper.toGenreDTOList(Objects.requireNonNull(root).genres));

        return m_movieDetailMapper.toMovieDetailsStringDTO(root, productionCompanies, productionCountries, genres);
    }

    public MoviesDTO getPopularMovies(int page)
    {
        var root = Objects.requireNonNull(m_restTemplate.<Root>getForObject(format(popularMoviesUrl, page), Root.class));
        return m_movieMapper.toMoviesDTO(m_movieMapper.toMovieDTO(root.results));
    }

    public MoviesDTO getMoviesByTitle(String movie)
    {
        var root = m_restTemplate.getForObject(format(searchMoviesUrl, movie.replace(" ", "%20")), Root.class);
        return m_movieMapper.toMoviesDTO(m_movieMapper.toMovieDTO(Objects.requireNonNull(root).results));
    }
}
