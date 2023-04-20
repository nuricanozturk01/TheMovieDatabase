package nuricanozturk.dev.movie.data.dal;

import nuricanozturk.dev.movie.data.repository.IMovieRepository;
import org.springframework.stereotype.Component;

@Component
public class MovieServiceHelper
{
    private final IMovieRepository m_movieRepository;

    public MovieServiceHelper(IMovieRepository movieRepository)
    {
        m_movieRepository = movieRepository;
    }
}
