package nuricanozturk.dev.movie.get.service;

import nuricanozturk.dev.dtolib.db.genericdtos.ProductionCompanyDTO;
import nuricanozturk.dev.dtolib.db.moviedto.MovieDbDTO;
import nuricanozturk.dev.dtolib.db.moviedto.MoviesDbDTO;
import nuricanozturk.dev.movie.data.dal.MovieServiceHelper;
import nuricanozturk.dev.movie.get.mapper.IMovieDTOMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.stream.StreamSupport;

import static java.lang.String.format;

@Service
public class MovieGetDBService
{
    private final MovieServiceHelper m_movieServiceHelper;
    private final IMovieDTOMapper m_movieDTOMapper;
    private final RestTemplate m_restTemplate;

    @Value("${generic_lib.find_company_name}")
    private String findCompanyNameUrl;

    public MovieGetDBService(MovieServiceHelper movieServiceHelper, IMovieDTOMapper movieDTOMapper, RestTemplate mRestTemplate)
    {
        m_movieServiceHelper = movieServiceHelper;
        m_movieDTOMapper = movieDTOMapper;
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
        return m_movieDTOMapper.toMovieDTO(m_movieServiceHelper.getMovieById(id).get());
    }

    public MoviesDbDTO getMoviesByProductionCompany(String companyName)
    {
        var company = m_restTemplate.getForObject(format(findCompanyNameUrl, companyName), ProductionCompanyDTO.class);
        return m_movieServiceHelper.getMoviesByProductionCompany(company.company_id);
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
