package nuricanozturk.dev.movie.save.service;

import nuricanozturk.dev.dtolib.api.moviedetaildto.MovieWithDetailStringDTO;
import nuricanozturk.dev.dtolib.db.moviedto.MovieDbDTO;
import nuricanozturk.dev.dtolib.mapper.api.IMovieMapper;
import nuricanozturk.dev.movie.data.dal.MovieDetailsServiceHelper;
import nuricanozturk.dev.movie.data.dal.MovieServiceHelper;
import nuricanozturk.dev.movie.data.entity.*;
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
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
public class MovieSaveService
{
    private final MovieServiceHelper m_movieServiceHelper;
    private final MovieDetailsServiceHelper m_movieDetailsServiceHelper;

    private final RestTemplate m_restTemplate;
    private final ValueConfig m_valueConfig;
    private final IMovieGenreMapper m_movieMapper;


    private boolean exists(String url)
    {
        return m_restTemplate.getForObject(url, MovieDbDTO.class) != null;
    }

    private <T> T getObj(String url, Class<T> $class)
    {
        return m_restTemplate.getForObject(url, $class);
    }

    private <T> void saveObj(String url, Class<T> $class, T obj)
    {
        m_restTemplate.postForEntity(url, obj, $class);
    }



    public MovieSaveService(MovieServiceHelper movieServiceHelper, MovieDetailsServiceHelper movieDetailsServiceHelper,
                            RestTemplate restTemplate, ValueConfig valueConfig, IMovieGenreMapper movieMapper)
    {
        m_movieServiceHelper = movieServiceHelper;
        m_movieDetailsServiceHelper = movieDetailsServiceHelper;
        m_restTemplate = restTemplate;
        m_valueConfig = valueConfig;
        m_movieMapper = movieMapper;
    }
    public ExistsDTO saveMovieById(long id)
    {
        //var movieFromTMDB = exists(format(m_movieGetUrl,id));

        /*if (movieFromTMDB)
            return new ExistsDTO(true);*/

        var movieWithDetail = m_restTemplate.getForObject(format(m_valueConfig.movieWithDetailUrl,id), MovieWithDetailStringDTO.class);
        // Exception

        var movieDetails = new MovieDetails(movieWithDetail.id, movieWithDetail.title);


        var genres =  m_restTemplate.getForObject(format(m_valueConfig.hideGenresUrl, movieWithDetail.genres), GenresDBDTO.class);
        var companies = m_restTemplate.getForObject(format(m_valueConfig.hideCompaniesUrl, movieWithDetail.production_companies), CompaniesDBDTO.class);
        var countries = m_restTemplate.getForObject(format(m_valueConfig.hideCountriesUrl, movieWithDetail.production_countries), CountriesDBDTO.class);


        var movieGenresTable = m_movieMapper.toMovieGenres(genres, movieDetails);
        var movieProductionCompaniesTable = m_movieMapper.toMovieProductionCompanies(companies, movieDetails);
        var movieProductionCountriesTable = m_movieMapper.toMovieProductionCountries(countries, movieDetails);


        movieDetails.setGenres(movieGenresTable);
        movieDetails.setProductionCompanies(movieProductionCompaniesTable);
        movieDetails.setProductionCountries(movieProductionCountriesTable);

        var movie = new Movie(movieWithDetail.original_language, movieWithDetail.title, movieWithDetail.overview,
                movieWithDetail.popularity,
                LocalDate.parse(movieWithDetail.release_date, DateTimeFormatter.ISO_LOCAL_DATE),
                movieWithDetail.vote_average);

        movie.setMovieDetail(movieDetails);

        m_movieServiceHelper.saveMovie(movie);

        return new ExistsDTO(false);
    }
}
