package nuricanozturk.dev.movie.data.dal;

import nuricanozturk.dev.movie.data.repository.IMovieDetailsRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class MovieDetailsServiceHelper
{
    private final IMovieDetailsRepository m_movieDetailsRepository;

    public MovieDetailsServiceHelper(IMovieDetailsRepository movieDetailsRepository)
    {
        m_movieDetailsRepository = movieDetailsRepository;
    }
}
