package nuricanozturk.dev.movie.get.service.controller;

import nuricanozturk.dev.movie.get.service.dto.MovieDetailDTO;
import nuricanozturk.dev.movie.get.service.api.service.MovieSearchService;
import nuricanozturk.dev.movie.get.service.dto.MovieDetailStringDTO;
import nuricanozturk.dev.movie.get.service.dto.MoviesDTO;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// TODO: Add exception handling for this module.
@RestController
@Scope("prototype")
@RequestMapping("api/movies/read")
public class MovieGetServiceController
{
    private final MovieSearchService m_service;

    public MovieGetServiceController(MovieSearchService service)
    {
        m_service = service;
    }

    @GetMapping("find/all/page")
    public MoviesDTO getMovies(@RequestParam("p") int page)
    {
        return m_service.getMovies(page);
    }

    @GetMapping("find/popular/page")
    public MoviesDTO getPopularMovies(@RequestParam("p") int page)
    {
        return m_service.getPopularMovies(page);
    }

    @GetMapping("find/detail/id")
    public MovieDetailStringDTO getMovieDetails(@RequestParam("id") int id)
    {
        return m_service.getMovieDetails(id);
    }
    @GetMapping("find/movie/title")
    public MoviesDTO getMoviesByTitle(@RequestParam("t") String title)
    {
        return m_service.getMoviesByTitle(title);
    }
}
