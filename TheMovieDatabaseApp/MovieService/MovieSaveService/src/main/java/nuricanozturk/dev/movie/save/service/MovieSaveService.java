package nuricanozturk.dev.movie.save.service;

import nuricanozturk.dev.movie.data.dal.MovieServiceHelper;
import org.springframework.stereotype.Service;

@Service
public class MovieSaveService
{
    private final MovieServiceHelper m_movieServiceHelper;

    public MovieSaveService(MovieServiceHelper movieServiceHelper)
    {
        m_movieServiceHelper = movieServiceHelper;
    }
}
