package nuricanozturk.dev.movie.data.controller;

import nuricanozturk.dev.movie.data.dal.MovieServiceHelper;
import nuricanozturk.dev.movie.data.entity.MovieWithDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("repo")
public class AppController
{
    private final MovieServiceHelper m_movieServiceHelper;

    public AppController(MovieServiceHelper movieServiceHelper)
    {
        m_movieServiceHelper = movieServiceHelper;
    }

    @GetMapping("movies")
    public MovieWithDetails getMovieWithDetail(@RequestParam("id") long id)
    {
        return m_movieServiceHelper.getMovieWithDetails(id);
    }
}
