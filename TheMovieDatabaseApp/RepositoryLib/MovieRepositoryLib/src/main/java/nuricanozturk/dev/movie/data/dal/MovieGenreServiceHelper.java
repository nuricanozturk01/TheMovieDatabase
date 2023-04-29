package nuricanozturk.dev.movie.data.dal;

import nuricanozturk.dev.movie.data.repository.IMovieGenresRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class MovieGenreServiceHelper
{
    private final IMovieGenresRepository m_movieGenresRepository;

    public MovieGenreServiceHelper(IMovieGenresRepository movieGenresRepository)
    {
        m_movieGenresRepository = movieGenresRepository;
    }
}
