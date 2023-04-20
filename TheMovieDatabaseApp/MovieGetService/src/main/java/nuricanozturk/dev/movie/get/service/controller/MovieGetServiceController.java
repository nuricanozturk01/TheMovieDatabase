package nuricanozturk.dev.movie.get.service.controller;

import nuricanozturk.dev.movie.get.service.api.entity.Movies;
import nuricanozturk.dev.movie.get.service.dto.MovieDetailsDTO;
import nuricanozturk.dev.movie.get.service.service.MovieGetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/movies/read")
public class MovieGetServiceController
{
    private final MovieGetService m_service;

    public MovieGetServiceController(MovieGetService service)
    {
        m_service = service;
    }

    @GetMapping("find/all")
    public Movies getMovies(@RequestParam("p") int page)
    {
        return m_service.getMovies(page);
    }

    @GetMapping("find/popular")
    public Movies getPopularMovies(@RequestParam("p") int page)
    {
        return m_service.getPopularMovies(page);
    }

    @GetMapping("find/detail/id")
    public MovieDetailsDTO getMovieDetails(@RequestParam("id") int id)
    {
        return m_service.getMovieDetails(id);
    }
}
