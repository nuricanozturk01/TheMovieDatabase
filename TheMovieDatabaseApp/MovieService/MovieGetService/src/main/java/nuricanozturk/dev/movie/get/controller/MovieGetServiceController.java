package nuricanozturk.dev.movie.get.controller;

import nuricanozturk.dev.movie.get.dto.MoviesDTO;
import nuricanozturk.dev.movie.get.service.MovieGetDBService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/local")
public class MovieGetServiceController
{
    private final MovieGetDBService m_service;

    public MovieGetServiceController(MovieGetDBService service)
    {
        m_service = service;
    }

    @GetMapping("/movies")
    public MoviesDTO getAllMovies()
    {
        return m_service.getMoviesFromDB();
    }
}
