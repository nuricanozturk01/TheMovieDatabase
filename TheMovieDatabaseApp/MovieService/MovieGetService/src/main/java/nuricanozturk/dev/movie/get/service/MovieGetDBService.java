package nuricanozturk.dev.movie.get.service;

import nuricanozturk.dev.dtolib.db.moviedto.MovieDbDTO;
import nuricanozturk.dev.dtolib.db.moviedto.MoviesDbDTO;
import nuricanozturk.dev.movie.data.dal.MovieServiceHelper;
import nuricanozturk.dev.movie.get.mapper.IMovieDTOMapper;
import org.springframework.stereotype.Service;

import java.util.stream.StreamSupport;

@Service
public class MovieGetDBService
{
    private final MovieServiceHelper m_movieServiceHelper;
    private final IMovieDTOMapper m_movieDTOMapper;

    public MovieGetDBService(MovieServiceHelper movieServiceHelper, IMovieDTOMapper movieDTOMapper)
    {
        m_movieServiceHelper = movieServiceHelper;
        m_movieDTOMapper = movieDTOMapper;
    }

    public MoviesDbDTO getMoviesFromDB()
    {
        return m_movieDTOMapper.toMoviesDTO(StreamSupport.stream(m_movieServiceHelper.getMovies().spliterator(), false)
                        .map(m_movieDTOMapper::toMovieDTO)
                        .toList());
    }

    public MovieDbDTO getMovieById(long id)
    {
        throw new UnsupportedOperationException("TODO");
    }

    public MovieDbDTO getMovieWithDetailsById(long id)
    {
        throw new UnsupportedOperationException("TODO");
    }

    public MovieDbDTO getMoviesByGenre(String genre)
    {
        throw new UnsupportedOperationException("TODO");
    }

    public MovieDbDTO getMoviesByProductionCompany(String company)
    {
        throw new UnsupportedOperationException("TODO");
    }


    public MovieDbDTO getMoviesByProductionCountry(String country)
    {
        throw new UnsupportedOperationException("TODO");
    }

    public MovieDbDTO getMoviesByReleaseDate(String releaseDate)
    {
        throw new UnsupportedOperationException("TODO");
    }

    public MovieDbDTO getMoviesByPopularity(double popularity)
    {
        throw new UnsupportedOperationException("TODO");
    }

    public MovieDbDTO getMoviesByVote(double begin, double end)
    {
        throw new UnsupportedOperationException("TODO");
    }
}
