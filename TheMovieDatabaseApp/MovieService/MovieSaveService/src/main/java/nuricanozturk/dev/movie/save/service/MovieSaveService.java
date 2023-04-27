package nuricanozturk.dev.movie.save.service;

import nuricanozturk.dev.dtolib.api.moviedetaildto.MovieWithDetailStringDTO;
import nuricanozturk.dev.dtolib.db.moviedto.MovieDbDTO;
import nuricanozturk.dev.dtolib.mapper.api.IMovieMapper;
import nuricanozturk.dev.movie.data.dal.MovieDetailsServiceHelper;
import nuricanozturk.dev.movie.data.dal.MovieServiceHelper;
import nuricanozturk.dev.movie.data.entity.*;
import nuricanozturk.dev.movie.save.configuration.ValueConfig;
import nuricanozturk.dev.movie.save.dto.ExistsDTO;
import nuricanozturk.dev.repository.generic.data.entity.Genre;
import nuricanozturk.dev.repository.generic.data.entity.ProductionCompany;
import nuricanozturk.dev.repository.generic.data.entity.ProductionCountry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
public class MovieSaveService
{
    private final MovieServiceHelper m_movieServiceHelper;
    private final MovieDetailsServiceHelper m_movieDetailsServiceHelper;

    private final RestTemplate m_restTemplate;
    private final ValueConfig m_valueConfig;


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
    private int[] workWithGenres(MovieWithDetailStringDTO movieDetails)
    {
        var arr = movieDetails.genres.split(",");
        var intArr = new int[arr.length];

        for (int i = 0; i < arr.length; i++)
        {
            var genre = getObj(format(m_valueConfig.findGenreByNameUrl, arr[i]), Genre.class);

            if (genre != null)
                intArr[i] = (int) genre.getGenre_id();
            else
            {
                var newGenre = new Genre(arr[i]);
                saveObj(m_valueConfig.saveGenreUrl, Genre.class, newGenre);
                var g = getObj(format(m_valueConfig.findGenreByNameUrl, arr[i]), Genre.class);
                intArr[i] = (int) g.getGenre_id();
            }

        }

        return intArr;
    }
    public MovieSaveService(MovieServiceHelper movieServiceHelper, MovieDetailsServiceHelper movieDetailsServiceHelper,
                            RestTemplate restTemplate, ValueConfig valueConfig)
    {
        m_movieServiceHelper = movieServiceHelper;
        m_movieDetailsServiceHelper = movieDetailsServiceHelper;
        m_restTemplate = restTemplate;
        m_valueConfig = valueConfig;
    }
    public ExistsDTO saveMovieById(long id)
    {
        //var movieFromTMDB = exists(format(m_movieGetUrl,id));

        /*if (movieFromTMDB)
            return new ExistsDTO(true);*/

        var movieWithDetail = m_restTemplate.getForObject(format(m_valueConfig.movieWithDetailUrl,id), MovieWithDetailStringDTO.class);
        // Exception

        var movieDetails = new MovieDetails(movieWithDetail.id, movieWithDetail.title);

        var genreIdx = workWithGenres(movieWithDetail);
        Arrays.stream(genreIdx).forEach(System.out::println);
        /*var genres = Arrays.stream(movieWithDetail.genres.split(",")).map(Genre::new).toList();
        var companies = Arrays.stream(movieWithDetail.production_companies.split(",")).map(ProductionCompany::new).toList();
        var countries = Arrays.stream(movieWithDetail.production_countries.split(",")).map(ProductionCountry::new).toList();

        genres.forEach(g -> saveObj(m_valueConfig.saveGenreUrl, Genre.class, g));
        companies.forEach(g -> saveObj(m_valueConfig.saveGenreUrl, ProductionCompany.class, g));
        countries.forEach(g -> saveObj(m_valueConfig.saveGenreUrl, ProductionCountry.class, g));

        var movieGenresTable = genres
                .stream()
                .map(g -> new MovieGenres(movieDetails,g.getGenre_id()))
                .collect(Collectors.toSet());
        var movieProductionCompaniesTable = companies
                .stream()
                .map(g -> new MovieProductionCompany(movieDetails, g.getCompany_id()))
                .collect(Collectors.toSet());
        var movieProductionCountriesTable = countries
                .stream()
                .map(g -> new MovieProductionCountry(movieDetails, g.getCountry_id()))
                .collect(Collectors.toSet());


        movieDetails.setGenres(movieGenresTable);
        movieDetails.setProductionCompanies(movieProductionCompaniesTable);
        movieDetails.setProductionCountries(movieProductionCountriesTable);

        var movie = new Movie(movieWithDetail.original_language, movieWithDetail.title, movieWithDetail.overview,
                movieWithDetail.popularity,
                LocalDate.parse(movieWithDetail.release_date, DateTimeFormatter.ISO_LOCAL_DATE),
                movieWithDetail.vote_average);
        movie.setMovieDetail(movieDetails);

        m_movieServiceHelper.saveMovie(movie);*/

        return new ExistsDTO(false);
    }
}
