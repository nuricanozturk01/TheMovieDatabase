package nuricanozturk.dev.movie.get.service;

import nuricanozturk.dev.movie.data.dal.MovieServiceHelper;
import nuricanozturk.dev.movie.get.IMovieDTOMapper;
import nuricanozturk.dev.movie.get.dto.MoviesDTO;
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

    public MoviesDTO getMoviesFromDB()
    {
        return m_movieDTOMapper.toMoviesDTO(StreamSupport.stream(m_movieServiceHelper.getMovies().spliterator(), false)
                        .map(m_movieDTOMapper::toMovieDTO)
                        .toList());
    }
}
