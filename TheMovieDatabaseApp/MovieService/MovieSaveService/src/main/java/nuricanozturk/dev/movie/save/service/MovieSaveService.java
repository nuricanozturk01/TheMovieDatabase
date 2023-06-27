package nuricanozturk.dev.movie.save.service;

import nuricanozturk.dev.dtolib.api.moviedetaildto.MovieWithDetailStringDTO;
import nuricanozturk.dev.dtolib.db.moviedto.MovieDbDTO;
import nuricanozturk.dev.movie.data.dal.MovieServiceHelper;
import nuricanozturk.dev.movie.data.entity.Movie;
import nuricanozturk.dev.movie.data.entity.MovieDetails;
import nuricanozturk.dev.movie.save.configuration.ValueConfig;
import nuricanozturk.dev.movie.save.dto.CompaniesDBDTO;
import nuricanozturk.dev.movie.save.dto.CountriesDBDTO;
import nuricanozturk.dev.movie.save.dto.ExistsDTO;
import nuricanozturk.dev.movie.save.dto.GenresDBDTO;
import nuricanozturk.dev.movie.save.mapper.IMovieGenreMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.lang.String.format;

@Service
public class MovieSaveService
{
    private final MovieServiceHelper m_movieServiceHelper;
    private final RestTemplate m_restTemplate;
    private final ValueConfig m_valueConfig;
    private final IMovieGenreMapper m_movieMapper;

    private boolean exists(String url)
    {
        var m = m_restTemplate.getForObject(url, MovieDetails.class);

        return m != null;
    }

    public MovieSaveService(MovieServiceHelper movieServiceHelper, RestTemplate restTemplate,
                            ValueConfig valueConfig, IMovieGenreMapper movieMapper)
    {
        m_movieServiceHelper = movieServiceHelper;
        m_restTemplate = restTemplate;
        m_valueConfig = valueConfig;
        m_movieMapper = movieMapper;
    }

    public ExistsDTO saveMovieById(long id) // TMDB id
    {
        /*var movieFromDB = exists(format(m_valueConfig.movieDetailsUrl, id));

        if (movieFromDB)
            return new ExistsDTO(true, false);*/
        <
        var movieWithDetail = m_restTemplate.getForObject(format(m_valueConfig.movieWithDetailUrl, id), MovieWithDetailStringDTO.class);
        var movieWithFullDetail = m_restTemplate.getForObject(format(m_valueConfig.movieFullDetailsUrl, id), nuricanozturk.dev.dtolib.entity.api.movie.MovieDetails.class);
        // Exception
       // System.out.println(movieWithDetail.title);
        var movieDetails = new MovieDetails(movieWithDetail.id, movieWithDetail.title);


        var genres = m_restTemplate.getForObject(format(m_valueConfig.hideGenresUrl, movieWithDetail.genres), GenresDBDTO.class);
        var companies = m_restTemplate.getForObject(format(m_valueConfig.hideCompaniesUrl, movieWithDetail.production_companies), CompaniesDBDTO.class);
        var countries = m_restTemplate.getForObject(format(m_valueConfig.hideCountriesUrl, movieWithDetail.production_countries), CountriesDBDTO.class);


        var movieGenresTable = m_movieMapper.toMovieGenres(genres, movieDetails);
        var movieProductionCompaniesTable = m_movieMapper.toMovieProductionCompanies(companies, movieDetails);
        var movieProductionCountriesTable = m_movieMapper.toMovieProductionCountries(countries, movieDetails);


        movieDetails.setGenres(movieGenresTable);
        movieDetails.setProductionCompanies(movieProductionCompaniesTable);
        movieDetails.setProductionCountries(movieProductionCountriesTable);
        movieDetails.setPosterPath(m_valueConfig.moviePosterPrefix + movieWithFullDetail.poster_path);

        var movie = new Movie(movieWithDetail.original_language, movieWithDetail.title, movieWithDetail.overview,
                movieWithDetail.popularity,
                LocalDate.parse(movieWithDetail.release_date, DateTimeFormatter.ISO_LOCAL_DATE),
                movieWithDetail.vote_average);
        movieDetails.setMovie(movie);
        movie.setMovieDetail(movieDetails);

        m_movieServiceHelper.saveMovie(movie);

        return new ExistsDTO(false, true);
    }

    public ExistsDTO removeById(long id)
    {
        var movie = m_restTemplate.getForObject(format(m_valueConfig.movieDetailsUrl, id), MovieDbDTO.class);
        if (movie != null){
            m_movieServiceHelper.deleteMovie(movie.movie_id);
            return new ExistsDTO(true, false);
        }
        return new ExistsDTO(false, false);
    }
}
