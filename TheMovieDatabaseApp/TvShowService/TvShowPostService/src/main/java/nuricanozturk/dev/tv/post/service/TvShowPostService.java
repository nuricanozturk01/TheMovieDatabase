package nuricanozturk.dev.tv.post.service;

import nuricanozturk.dev.dtolib.api.moviedetaildto.MovieWithDetailStringDTO;
import nuricanozturk.dev.dtolib.db.moviedto.MovieDbDTO;
import nuricanozturk.dev.tv.data.dal.TvShowRepositoryHelper;
import nuricanozturk.dev.tv.data.dto.CompaniesDBDTO;
import nuricanozturk.dev.tv.data.dto.CountriesDBDTO;
import nuricanozturk.dev.tv.data.dto.ExistsDTO;
import nuricanozturk.dev.tv.data.dto.GenresDBDTO;
import nuricanozturk.dev.tv.data.entity.TvShowDetails;
import nuricanozturk.dev.tv.post.config.ValueConfig;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.lang.String.format;

@Service
public class TvShowPostService
{
    private final TvShowRepositoryHelper m_tvShowRepositoryHelper;
    private final RestTemplate m_restTemplate;
    private final ValueConfig m_valueConfig;

    public TvShowPostService(TvShowRepositoryHelper tvShowRepositoryHelper, RestTemplate restTemplate, ValueConfig valueConfig)
    {
        m_tvShowRepositoryHelper = tvShowRepositoryHelper;
        m_restTemplate = restTemplate;
        m_valueConfig = valueConfig;
    }

    public ExistsDTO saveTvShowById(long id) // TMDB id
    {
       /* *//*var movieFromDB = exists(format(m_valueConfig.movieDetailsUrl, id));

        if (movieFromDB)
            return new ExistsDTO(true, false);*//*

        var movieWithDetail = m_restTemplate.getForObject(format(m_valueConfig.movieWithDetailUrl, id), MovieWithDetailStringDTO.class);
        var movieWithFullDetail = m_restTemplate.getForObject(format(m_valueConfig.movieFullDetailsUrl, id), nuricanozturk.dev.dtolib.entity.api.movie.MovieDetails.class);
        // Exception
        // System.out.println(movieWithDetail.title);
        var movieDetails = new TvShowDetails(movieWithDetail.id, movieWithDetail.title);


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

        return new ExistsDTO(false, true);*/

        throw new UnsupportedOperationException("NOT IMPLEMENTED YET!");
    }

    public ExistsDTO removeById(long id)
    {
        /*var movie = m_restTemplate.getForObject(format(m_valueConfig.movieDetailsUrl, id), MovieDbDTO.class);
        if (movie != null){
            m_movieServiceHelper.deleteMovie(movie.movie_id);
            return new ExistsDTO(true, false);
        }
        return new ExistsDTO(false, false);*/
        throw new UnsupportedOperationException("NOT IMPLEMENTED YET!");
    }
}
