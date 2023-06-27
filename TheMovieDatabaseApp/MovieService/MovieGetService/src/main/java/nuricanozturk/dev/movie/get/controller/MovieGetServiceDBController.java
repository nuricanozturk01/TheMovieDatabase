package nuricanozturk.dev.movie.get.controller;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import nuricanozturk.dev.dtolib.db.moviedto.MovieDbDTO;
import nuricanozturk.dev.dtolib.db.moviedto.MovieWithDetailStringDbDTO;
import nuricanozturk.dev.dtolib.db.moviedto.MovieWithDetailsStringDbDTO;
import nuricanozturk.dev.dtolib.db.moviedto.MoviesDbDTO;
import nuricanozturk.dev.movie.get.service.MovieGetDBService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

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

    @GetMapping("find/movie/id")
    public MovieDbDTO getMovieById(@RequestParam("id") int id)
    {
        return m_service.getMovieById(id);
    }

    @GetMapping("find/title")
    public MoviesDbDTO getMovieByTitle(@RequestParam("t") String movieTitle)
    {
        return m_service.getMoviesByTitle(movieTitle);
    }

    @GetMapping("find/movies/date/between")
    public MoviesDbDTO getMoviesByReleaseDateBetween(@RequestParam("b") LocalDate b, @RequestParam("e") LocalDate e)
    {
        return m_service.getMoviesByReleaseDate(b, e);
    }

    @GetMapping("find/movies/date")
    public MoviesDbDTO getMoviesByReleaseDate(@RequestParam("d") LocalDate releaseDate)
    {
        return m_service.getMoviesByReleaseDate(releaseDate);
    }

    @GetMapping("find/movies/movie_with_detail/id")
    public MovieWithDetailStringDbDTO getMovieWithDetailString(@RequestParam("id") long id)
    {
        return m_service.getMovieWithDetailString(id);
    }
    @GetMapping("find/movies/movie_with_detail/all")
    public MovieWithDetailsStringDbDTO getMovieWithDetailString()
    {
        return m_service.getMovieWithDetailAll();
    }

    @GetMapping("find/movies/popularity/between")
    public MoviesDbDTO getMoviesByPopularity(@RequestParam("b") @Min(0) double begin, @RequestParam("e") double end)
    {
        return m_service.getMoviesByPopularity(begin, end);
    }

    @GetMapping("find/movies/vote/between")
    public MoviesDbDTO getMoviesByVote(@RequestParam("b") @Min(0) double begin, @RequestParam("e") @Max(10) double end)
    {
        return m_service.getMoviesByVote(begin, end);
    }

    @GetMapping("find/movies/company")
    public MoviesDbDTO getMoviesByProductionCompany(@RequestParam("company") String company)
    {
        return m_service.getMoviesByProductionCompany(company);
    }

    @GetMapping("find/movies/country")
    public MoviesDbDTO getMoviesByProductionCountry(@RequestParam("country") String country)
    {
       return m_service.getMoviesByProductionCountry(country);
    }

    @GetMapping("find/movies/genre")
    public MoviesDbDTO getMoviesByGenre(@RequestParam("genre") String genre)
    {
        return m_service.getMoviesByGenre(genre);
    }

    @GetMapping("find/movies_with_detail/company")
    public MovieWithDetailsStringDbDTO getMoviesWithDetailByProductionCompany(@RequestParam("company") String company)
    {
        return m_service.getMoviesWithDetailByProductionCompany(company);
    }

    @GetMapping("find/movies_with_detail/country")
    public MovieWithDetailsStringDbDTO getMoviesWithDetailByProductionCountry(@RequestParam("country") String country)
    {
        return m_service.getMoviesWithDetailByProductionCountry(country);
    }

    @GetMapping("find/movies_with_detail/genre")
    public MovieWithDetailsStringDbDTO getMoviesWithDetailByGenre(@RequestParam("genre") String genre)
    {
        return m_service.getMoviesWithDetailByGenre(genre);
    }
}