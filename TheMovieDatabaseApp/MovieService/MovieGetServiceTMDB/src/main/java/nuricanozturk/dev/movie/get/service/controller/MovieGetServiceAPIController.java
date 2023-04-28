package nuricanozturk.dev.movie.get.service.controller;

import nuricanozturk.dev.dtolib.api.moviedetaildto.MovieDetailStringDTO;
import nuricanozturk.dev.dtolib.api.moviedetaildto.MovieWithDetailStringDTO;
import nuricanozturk.dev.dtolib.api.moviedto.*;
import nuricanozturk.dev.dtolib.entity.api.movie.MovieDetails;
import nuricanozturk.dev.movie.get.service.api.service.MovieAPISearchService;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// TODO: Add exception handling for this module.
@RestController
@Scope("prototype")
@RequestMapping("api/movies/read")
public class MovieGetServiceAPIController
{
    private final MovieAPISearchService m_service;

    public MovieGetServiceAPIController(MovieAPISearchService service)
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

    @GetMapping("hide/find/detail/id")
    public MovieDetails getDetails(@RequestParam("id") int id)
    {
        return m_service._getDetails(id);
    }
    @GetMapping("find/movies/title")
    public MoviesDTO getMoviesByTitle(@RequestParam("t") String title)
    {
        return m_service.getMoviesByTitle(title);
    }

    @GetMapping("find/movie/movie_detail/id")
    public MovieWithDetailStringDTO getMovieWithDetails(@RequestParam("id") int id)
    {
        return m_service.getMovieWithDetails(id);
    }
    @GetMapping("find/trending/week")
    public MoviesDTO getTrendingMoviesWeekly()
    {
        return m_service.getTrendingMoviesWeekly();
    }

    @GetMapping("find/trending/daily")
    public MoviesDTO getTrendingMoviesDaily()
    {
        return m_service.getTrendingMoviesDaily();
    }
    @GetMapping("find/rates/page")
    public MoviesDTO getTopRatedMovies(@RequestParam("p") int page)
    {
        // page must be smaller or equal than 500
        return m_service.getTopRatedMovies(page);
    }
}
