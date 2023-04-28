package nuricanozturk.dev.movie.get.controller;

import nuricanozturk.dev.dtolib.db.moviedto.MovieDbDTO;
import nuricanozturk.dev.dtolib.db.moviedto.MoviesDbDTO;
import nuricanozturk.dev.movie.get.service.MovieGetDBService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/movies/db/read")
public class MovieGetServiceDBController
{
    private final MovieGetDBService m_service;

    public MovieGetServiceDBController(MovieGetDBService service)
    {
        m_service = service;
    }

    @GetMapping("find/all")
    public MoviesDbDTO getAllMovies()
    {
        return m_service.getMoviesFromDB();
    }

    @GetMapping("find/id")
    public MovieDbDTO getMovieById(@RequestParam("id") long id)
    {
        throw new UnsupportedOperationException("TODO");
    }

    @GetMapping("find/movie_detail/id")
    public MovieDbDTO getMovieWithDetailsById(@RequestParam("id") long id)
    {
        throw new UnsupportedOperationException("TODO");
    }

    @GetMapping("find/title")
    public MovieDbDTO getMovieByTitle(@RequestParam("t") String movieTitle)
    {
        throw new UnsupportedOperationException("TODO");
    }

    @GetMapping("find/movies/genre")
    public MovieDbDTO getMoviesByGenre(@RequestParam("g") String genre)
    {
        throw new UnsupportedOperationException("TODO");
    }

    @GetMapping("find/movies/production_company")
    public MoviesDbDTO getMoviesByProductionCompany(@RequestParam("company") String company)
    {
        return m_service.getMoviesByProductionCompany(company);
    }

    @GetMapping("find/movies/production_country")
    public MovieDbDTO getMoviesByProductionCountry(@RequestParam("country") String country)
    {
        throw new UnsupportedOperationException("TODO");
    }

    @GetMapping("find/movies/release_date")
    public MovieDbDTO getMoviesByReleaseDate(@RequestParam("date") String releaseDate)
    {
        throw new UnsupportedOperationException("TODO");
    }
    @GetMapping("find/movies/popularity/between")
    public MoviesDbDTO getMoviesByPopularity(@RequestParam("b") double begin, @RequestParam("e") double end)
    {
        return m_service.getMoviesByPopularity(begin, end);
    }
    @GetMapping("find/movies/vote/between")
    public MoviesDbDTO getMoviesByVote(@RequestParam("b") double begin, @RequestParam("e") double end)
    {
        return m_service.getMoviesByVote(begin, end);
    }
}
