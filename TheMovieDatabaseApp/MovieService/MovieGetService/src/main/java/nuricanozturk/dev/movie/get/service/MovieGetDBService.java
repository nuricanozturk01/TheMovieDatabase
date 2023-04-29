package nuricanozturk.dev.movie.get.service;

import nuricanozturk.dev.dtolib.db.moviedto.*;
import nuricanozturk.dev.dtolib.mapper.db.mapper.MovieWithDetailStringDTOMapper;
import nuricanozturk.dev.movie.data.dal.MovieServiceHelper;
import nuricanozturk.dev.movie.get.dto.GenreDbDTO;
import nuricanozturk.dev.movie.get.dto.ProductionCompanyDbDTO;
import nuricanozturk.dev.movie.get.dto.ProductionCountryDbDTO;
import nuricanozturk.dev.movie.get.mapper.IMovieDTOMapper;
import nuricanozturk.dev.movie.get.mapper.IMovieDetailsDTOMapper;
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
    private final IMovieDetailsDTOMapper m_movieDetailsDTOMapper;
    private final MovieWithDetailStringDTOMapper m_movieWithDetailStringDTOMapper;
    private final RestTemplate m_restTemplate;

    @Value("${generic_lib.find_genre_id}")
    private String getGenresByIdUrl;

    @Value("${generic_lib.find_company_id}")
    private String getProductionCompaniesByIdUrl;

    @Value("${generic_lib.find_country_id}")
    private String getProductionCountryByIdUrl;

    public MovieGetDBService(MovieServiceHelper movieServiceHelper, IMovieDTOMapper movieDTOMapper,
                             IMovieDetailsDTOMapper movieDetailsDTOMapper,
                             MovieWithDetailStringDTOMapper movieWithDetailStringDTOMapper, RestTemplate mRestTemplate)
    {
        m_movieServiceHelper = movieServiceHelper;
        m_movieDTOMapper = movieDTOMapper;
        m_movieDetailsDTOMapper = movieDetailsDTOMapper;
        m_movieWithDetailStringDTOMapper = movieWithDetailStringDTOMapper;
        m_restTemplate = mRestTemplate;
    }

    public MoviesDbDTO getMoviesFromDB()
    {
        return m_movieDTOMapper.toMoviesDTO(StreamSupport.stream(m_movieServiceHelper.getMovies().spliterator(), false)
                        .map(m_movieDTOMapper::toMovieDTO)
                        .toList());
    }
    public MoviesDbDTO getMoviesByTitle(String title)
    {
        return m_movieServiceHelper.getMoviesByTitle(title);
    }
    public MovieDbDTO getMovieById(long id)
    {
        return m_movieDTOMapper.toMovieDTO(m_movieServiceHelper.getMovieById(id).orElse(null));
    }

    public MoviesDbDTO getMoviesByProductionCompany(String companyName)
    {
        /*var company = m_restTemplate.getForObject(format(findCompanyNameUrl, companyName), ProductionCompanyDTO.class);
        return m_movieServiceHelper.getMoviesByProductionCompany(company.company_id);*/

        return null;
    }

    public MoviesDbDTO getMoviesByReleaseDate(LocalDate releaseDate)
    {
        return m_movieServiceHelper.getMoviesByReleaseDate(releaseDate);
    }

    public MoviesDbDTO getMoviesByReleaseDate(LocalDate begin, LocalDate end)
    {
        return m_movieServiceHelper.getMoviesByReleaseDateBetween(begin, end);
    }

    public MoviesDbDTO getMoviesByPopularity(double begin, double end)
    {
        return m_movieServiceHelper.getMoviesByPopularity(begin ,end);
    }

    public MoviesDbDTO getMoviesByVote(double begin, double end)
    {
        return m_movieServiceHelper.getMoviesByVote(begin, end);
    }

    public MovieDetailDbDTO getMovieDetailsByRealMovieId(long id)
    {
        var movie = getMovieById(id);
        var genresStr = getGenresStr(movie);
        var companiesStr = getCompaniesStr(movie);
        var countriesStr = getCountriesStr(movie);


        return new MovieDetailDbDTO(movie.movie_id, movie.movie_id, movie.title, genresStr, companiesStr, countriesStr);
    }

    public MovieWithDetailStringDbDTO getMovieWithDetailString(long id)
    {
        var movie = getMovieById(id);
        var details = getMovieDetailsByRealMovieId(id);

        return m_movieWithDetailStringDTOMapper.toMovieWithDetailStringDbDTO(movie, details);

    }

    private String getCountriesStr(MovieDbDTO movie)
    {
        return m_movieServiceHelper.getMovieProductionCountryByMovieDbId(movie.movie_id)
                .stream()
                .map(mc -> m_restTemplate.getForObject(format(getProductionCountryByIdUrl, mc.getCountry_id()), ProductionCountryDbDTO.class))
                .map(mc -> mc.getName())
                .collect(Collectors.joining(","));
    }

    private String getCompaniesStr(MovieDbDTO movie)
    {
        return m_movieServiceHelper.getMovieProductionCompaniesByMovieDbId(movie.movie_id)
                .stream()
                .map(mc -> m_restTemplate.getForObject(format(getProductionCompaniesByIdUrl, mc.getCompany_id()), ProductionCompanyDbDTO.class))
                .map(mc -> mc.getName())
                .collect(Collectors.joining(","));
    }

    private String getGenresStr(MovieDbDTO movie)
    {
        return m_movieServiceHelper.getMovieGenresByMovieDbId(movie.movie_id)
                .stream()
                .map(mg -> m_restTemplate.getForObject(format(getGenresByIdUrl, mg.getGenre_id()), GenreDbDTO.class))
                .map(mg -> mg.getName())
                .collect(Collectors.joining(","));
    }

    /*public List<MovieGenres> getMovieGenres(long id)
    {
        return m_movieServiceHelper.getMovieGenresByMovieDbId(id);
    }*/

    //---------------------------------------------------------------------------------
    public MovieDbDTO getMovieWithDetailsById(long id)
    {
        throw new UnsupportedOperationException("TODO");
    }

    public MovieDbDTO getMoviesByGenre(String genre)
    {
        throw new UnsupportedOperationException("TODO");
    }
    public MovieDbDTO getMoviesByProductionCountry(String country)
    {
        throw new UnsupportedOperationException("TODO");
    }
}
