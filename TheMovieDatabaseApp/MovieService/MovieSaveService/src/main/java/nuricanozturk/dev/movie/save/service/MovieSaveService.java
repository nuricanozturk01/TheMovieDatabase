package nuricanozturk.dev.movie.save.service;

import nuricanozturk.dev.dtolib.api.moviedetaildto.MovieWithDetailStringDTO;
import nuricanozturk.dev.dtolib.db.moviedto.MovieDbDTO;
import nuricanozturk.dev.dtolib.mapper.api.IMovieMapper;
import nuricanozturk.dev.movie.data.dal.MovieDetailsServiceHelper;
import nuricanozturk.dev.movie.data.dal.MovieServiceHelper;
import nuricanozturk.dev.movie.data.entity.*;
import nuricanozturk.dev.movie.save.dto.ExistsDTO;
import nuricanozturk.dev.repository.generic.data.entity.Genre;
import nuricanozturk.dev.repository.generic.data.entity.ProductionCompany;
import nuricanozturk.dev.repository.generic.data.entity.ProductionCountry;
import nuricanozturk.dev.repository.generic.repository.IGenreRepository;
import nuricanozturk.dev.repository.generic.repository.IProductionCompanyRepository;
import nuricanozturk.dev.repository.generic.repository.IProductionCountryRepository;
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
    private final IGenreRepository m_genreRepository;
    private final IProductionCompanyRepository m_productionCompanyRepository;
    private final IProductionCountryRepository m_productionCountryRepository;
    private final IMovieMapper m_movieMapper;
    private final RestTemplate m_restTemplate;

    @Value("${movie.read.service.find_title.url}")
    private String m_movieGetUrl;
    @Value("${movie.tmdb_service.find_with_detail.url}")
    private String m_movieWithDetailUrl;
    private boolean exists(String url)
    {
        return m_restTemplate.getForObject(url, MovieDbDTO.class) != null;
    }
    public MovieSaveService(MovieServiceHelper movieServiceHelper, MovieDetailsServiceHelper movieDetailsServiceHelper,
                            IGenreRepository genreRepository, IProductionCompanyRepository productionCompanyRepository,
                            IProductionCountryRepository productionCountryRepository, IMovieMapper movieMapper,
                            RestTemplate restTemplate)
    {
        m_movieServiceHelper = movieServiceHelper;
        m_movieDetailsServiceHelper = movieDetailsServiceHelper;
        m_genreRepository = genreRepository;
        m_productionCompanyRepository = productionCompanyRepository;
        m_productionCountryRepository = productionCountryRepository;
        m_movieMapper = movieMapper;
        m_restTemplate = restTemplate;
    }
    public ExistsDTO saveMovieById(long id)
    {
        //var movieFromTMDB = exists(format(m_movieGetUrl,id));

        /*if (movieFromTMDB)
            return new ExistsDTO(true);*/

        var movieWithDetail = m_restTemplate.getForObject(format(m_movieWithDetailUrl,id), MovieWithDetailStringDTO.class);
        // Exception

        var movieDetails = new MovieDetails(movieWithDetail.id, movieWithDetail.title);

        var genres = Arrays.stream(movieWithDetail.genres.split(","))
                .map(Genre::new).toList();
        var companies = Arrays.stream(movieWithDetail.production_companies.split(","))
                .map(ProductionCompany::new).toList();
        var countries = Arrays.stream(movieWithDetail.production_countries.split(","))
                .map(ProductionCountry::new).toList();

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

        m_movieServiceHelper.saveMovie(movie);

        return new ExistsDTO(false);
    }
}
