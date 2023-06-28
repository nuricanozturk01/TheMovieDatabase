package nuricanozturk.dev.movie.get.service;

import nuricanozturk.dev.dtolib.db.genericdtos.GenreDTO;
import nuricanozturk.dev.dtolib.db.genericdtos.ProductionCompanyDTO;
import nuricanozturk.dev.dtolib.db.genericdtos.ProductionCountryDTO;
import nuricanozturk.dev.dtolib.db.moviedto.*;
import nuricanozturk.dev.dtolib.mapper.db.mapper.MovieWithDetailStringDTOMapper;
import nuricanozturk.dev.movie.data.dal.MovieServiceHelper;
import nuricanozturk.dev.movie.data.mapper.IMovieDbMapper;
import nuricanozturk.dev.movie.get.dto.GenreDbDTO;
import nuricanozturk.dev.movie.get.dto.ProductionCompanyDbDTO;
import nuricanozturk.dev.movie.get.dto.ProductionCountryDbDTO;
import nuricanozturk.dev.movie.get.mapper.IMovieDTOMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static java.lang.String.format;

@Service
public class MovieGetDBService
{
    private final MovieServiceHelper m_movieServiceHelper;
    private final IMovieDTOMapper m_movieDTOMapper;
    private final IMovieDbMapper m_movieDbMapper;
    private final MovieWithDetailStringDTOMapper m_movieWithDetailStringDTOMapper;
    private final RestTemplate m_restTemplate;

    @Value("${generic_lib.find_genre_id}")
    private String getGenresByIdUrl;

    @Value("${generic_lib.find_company_id}")
    private String getProductionCompaniesByIdUrl;

    @Value("${generic_lib.find_country_id}")
    private String getProductionCountryByIdUrl;

    @Value("${generic_lib.find_company_name}")
    private String findCompanyNameUrl;

    @Value("${generic_lib.find_genre_name}")
    private String findGenreNameUrl;

    @Value("${generic_lib.find_country_name}")
    private String findCountryUrl;

    public MovieGetDBService(MovieServiceHelper movieServiceHelper, IMovieDTOMapper movieDTOMapper,
                             MovieWithDetailStringDTOMapper movieWithDetailStringDTOMapper,
                             RestTemplate mRestTemplate, IMovieDbMapper movieDbMapper)
    {
        m_movieDbMapper = movieDbMapper;
        m_movieServiceHelper = movieServiceHelper;
        m_movieDTOMapper = movieDTOMapper;
        m_movieWithDetailStringDTOMapper = movieWithDetailStringDTOMapper;
        m_restTemplate = mRestTemplate;
    }

    public MoviesDbDTO getMoviesFromDB()
    {
        return m_movieDTOMapper.toMoviesDTO(StreamSupport.stream(m_movieServiceHelper.getMovies().spliterator(), false)
                .map(m_movieDTOMapper::toMovieDTO).toList());
    }

    public MoviesDbDTO getMoviesByTitle(String title)
    {
        return m_movieDbMapper.toMoviesDbDTO(m_movieDbMapper.toMovieDbDTO(StreamSupport
                .stream(m_movieServiceHelper.getMoviesByTitle(title).spliterator(), false).toList()));
    }

    public MovieDbDTO getMovieById(long id)
    {
        return m_movieDTOMapper.toMovieDTO(m_movieServiceHelper.getMovieById(id).orElse(null));
    }

    public MoviesDbDTO getMoviesByReleaseDate(LocalDate releaseDate)
    {
        return m_movieDbMapper.toMoviesDbDTO(m_movieDbMapper.toMovieDbDTO(StreamSupport
                .stream(m_movieServiceHelper.getMoviesByReleaseDate(releaseDate)
                        .spliterator(), false).toList()));
    }

    public MoviesDbDTO getMoviesByReleaseDate(LocalDate begin, LocalDate end)
    {
        return m_movieDbMapper.toMoviesDbDTO(m_movieDbMapper.toMovieDbDTO(StreamSupport
                .stream(m_movieServiceHelper.getMoviesByReleaseDateBetween(begin, end).spliterator(), false).toList()));
    }

    public MoviesDbDTO getMoviesByPopularity(double begin, double end)
    {
        return m_movieDbMapper.toMoviesDbDTO(m_movieDbMapper.toMovieDbDTO(StreamSupport
                .stream(m_movieServiceHelper.getMoviesByPopularity(begin, end).spliterator(), false).toList()));
    }

    public MoviesDbDTO getMoviesByVote(double begin, double end)
    {
        return m_movieDbMapper.toMoviesDbDTO(m_movieDbMapper.toMovieDbDTO(StreamSupport
                .stream(m_movieServiceHelper.getMoviesByVote(begin, end).spliterator(), false).toList()));
    }

    public MoviesDbDTO getMoviesByProductionCompany(String companyName)
    {
        var company = m_restTemplate.getForObject(format(findCompanyNameUrl, companyName), ProductionCompanyDTO.class);
        var movies = StreamSupport.stream(m_movieServiceHelper.getMoviesByProductionCompany(company.company_id).spliterator(), false).toList();

        return m_movieDbMapper.toMoviesDbDTO(m_movieDbMapper.toMovieDbDTO(movies));
    }

    public MovieDetailDbDTO getMovieDetailsByMovieId(long id)
    {
        var movie = getMovieById(id);
        var details = m_movieServiceHelper.getMovieDetails(id);
        var poster_path = details.get().getPosterPath();

        return new MovieDetailDbDTO(movie.movie_id,
                details.get().getReal_movie_id(), movie.title,
                getGenresStr(movie.movie_id), getCompaniesStr(movie),
                getCountriesStr(movie), poster_path);
    }

    public MovieWithDetailStringDbDTO getMovieWithDetailString(long id)
    {
        var movie = getMovieById(id);
        var details = getMovieDetailsByMovieId(id);

        return m_movieWithDetailStringDTOMapper.toMovieWithDetailStringDbDTO(movie, details);

    }

    private String getCountriesStr(MovieDbDTO movie)
    {
        return m_movieServiceHelper.getMovieProductionCountryByMovieDbId(movie.movie_id).stream()
                .map(mc -> m_restTemplate.getForObject(format(getProductionCountryByIdUrl, mc.getCountry_id()), ProductionCountryDbDTO.class))
                .map(mc -> mc.getName()).collect(Collectors.joining(","));
    }

    private String getCompaniesStr(MovieDbDTO movie)
    {
        return m_movieServiceHelper.getMovieProductionCompaniesByMovieDbId(movie.movie_id).stream()
                .map(mc -> m_restTemplate.getForObject(format(getProductionCompaniesByIdUrl, mc.getCompany_id()), ProductionCompanyDbDTO.class))
                .map(mc -> mc.getName()).collect(Collectors.joining(","));
    }

    private String getGenresStr(long id)
    {
        return m_movieServiceHelper.getMovieGenresByMovieDbId(id).stream()
                .map(mg -> m_restTemplate.getForObject(format(getGenresByIdUrl, mg.getGenre_id()), GenreDbDTO.class))
                .map(mg -> mg.getName()).collect(Collectors.joining(","));
    }

    public MoviesDbDTO getMoviesByGenre(String genre)
    {
        var company = m_restTemplate.getForObject(format(findGenreNameUrl, genre), GenreDTO.class);
        var movies = StreamSupport.stream(m_movieServiceHelper.getMoviesByGenre(company.getGenre_id()).spliterator(), false).toList();

        return m_movieDbMapper.toMoviesDbDTO(m_movieDbMapper.toMovieDbDTO(movies));
    }

    public MoviesDbDTO getMoviesByProductionCountry(String name)
    {
        var country = m_restTemplate.getForObject(format(findCountryUrl, name), ProductionCountryDTO.class);
        var movies = StreamSupport.stream(m_movieServiceHelper.getMoviesByProductionCountry(country.getCountry_id()).spliterator(), false).toList();

        return m_movieDbMapper.toMoviesDbDTO(m_movieDbMapper.toMovieDbDTO(movies));
    }

    public MovieWithDetailsStringDbDTO getMoviesWithDetailByProductionCompany(String company)
    {
        return m_movieWithDetailStringDTOMapper.toMovieWithDetailsStringDTO(getMoviesByProductionCompany(company).movies.stream().map(movie -> m_movieWithDetailStringDTOMapper
                .toMovieWithDetailStringDbDTO(movie, getMovieDetailsByMovieId(movie.movie_id))).toList());
    }

    public MovieWithDetailsStringDbDTO getMoviesWithDetailByProductionCountry(String country)
    {
        return m_movieWithDetailStringDTOMapper.toMovieWithDetailsStringDTO(getMoviesByProductionCountry(country).movies.stream().map(movie -> m_movieWithDetailStringDTOMapper
                .toMovieWithDetailStringDbDTO(movie, getMovieDetailsByMovieId(movie.movie_id))).toList());
    }

    public MovieWithDetailsStringDbDTO getMoviesWithDetailByGenre(String genre)
    {
        return m_movieWithDetailStringDTOMapper.toMovieWithDetailsStringDTO(getMoviesByGenre(genre).movies.stream().map(movie -> m_movieWithDetailStringDTOMapper
                .toMovieWithDetailStringDbDTO(movie, getMovieDetailsByMovieId(movie.movie_id))).toList());
    }

    public MovieWithDetailsStringDbDTO getMovieWithDetailAll()
    {
        var movies = getMoviesFromDB();

        return m_movieWithDetailStringDTOMapper.toMovieWithDetailsStringDTO(movies.movies.stream().map(movie -> m_movieWithDetailStringDTOMapper
                .toMovieWithDetailStringDbDTO(movie, getMovieDetailsByMovieId(movie.movie_id))).toList());
    }
}