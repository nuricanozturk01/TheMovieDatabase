package nuricanozturk.dev.movie.data.dal;

import nuricanozturk.dev.movie.data.repository.IGenreRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class GenreServiceHelper
{
    private final IGenreRepository m_genreRepository;

    public GenreServiceHelper(IGenreRepository genreRepository)
    {
        m_genreRepository = genreRepository;
    }
}
