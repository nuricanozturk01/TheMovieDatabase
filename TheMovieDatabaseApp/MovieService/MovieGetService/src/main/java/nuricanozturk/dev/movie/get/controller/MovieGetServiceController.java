package nuricanozturk.dev.movie.get.controller;

import nuricanozturk.dev.movie.get.service.MovieGetDBService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/movies/db")
public class MovieGetServiceController
{
    private final MovieGetDBService m_service;

    public MovieGetServiceController(MovieGetDBService service)
    {
        m_service = service;
    }

    @GetMapping("find/all")
    public MoviesDTO getAllMovies()
    {
        return m_service.getMoviesFromDB();
    }

    @GetMapping("find/id")
    public MovieDTO getMovieById(@RequestParam("id") long id)
    {
        throw new UnsupportedOperationException("TODO");
    }

    @GetMapping("find/movie_detail/id")
    public MovieDTO getMovieWithDetailsById(@RequestParam("id") long id)
    {
        throw new UnsupportedOperationException("TODO");
    }

    @GetMapping("find/title")
    public MovieDTO getMovieByTitle(@RequestParam("t") String movieTitle)
    {
        throw new UnsupportedOperationException("TODO");
    }

    @GetMapping("find/movies/genre")
    public MovieDTO getMoviesByGenre(@RequestParam("g") String genre)
    {
        throw new UnsupportedOperationException("TODO");
    }

    @GetMapping("find/movies/production_company")
    public MovieDTO getMoviesByProductionCompany(@RequestParam("company") String company)
    {
        throw new UnsupportedOperationException("TODO");
    }

    @GetMapping("find/movies/production_country")
    public MovieDTO getMoviesByProductionCountry(@RequestParam("country") String country)
    {
        throw new UnsupportedOperationException("TODO");
    }

    @GetMapping("find/movies/release_date")
    public MovieDTO getMoviesByReleaseDate(@RequestParam("date") String releaseDate)
    {
        throw new UnsupportedOperationException("TODO");
    }
    @GetMapping("find/movies/popularity")
    public MovieDTO getMoviesByPopularity(@RequestParam("p") double popularity)
    {
        throw new UnsupportedOperationException("TODO");
    }
    @GetMapping("find/movies/vote/between")
    public MovieDTO getMoviesByVote(@RequestParam("b") double begin, @RequestParam("e") double end)
    {
        throw new UnsupportedOperationException("TODO");
    }
}
