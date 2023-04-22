package nuricanozturk.dev.movie.save.service;

import nuricanozturk.dev.movie.data.dal.MovieDetailsServiceHelper;
import nuricanozturk.dev.movie.data.dal.MovieServiceHelper;
import org.springframework.stereotype.Service;

@Service
public class MovieSaveService
{
    private final MovieServiceHelper m_movieServiceHelper;
    private final MovieDetailsServiceHelper m_movieDetailsServiceHelper;

    public MovieSaveService(MovieServiceHelper movieServiceHelper, MovieDetailsServiceHelper movieDetailsServiceHelper)
    {
        m_movieServiceHelper = movieServiceHelper;
        m_movieDetailsServiceHelper = movieDetailsServiceHelper;
    }


}
