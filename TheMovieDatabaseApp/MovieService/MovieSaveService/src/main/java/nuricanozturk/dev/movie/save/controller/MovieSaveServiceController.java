package nuricanozturk.dev.movie.save.controller;

import nuricanozturk.dev.dtolib.db.moviedto.MovieDbDTO;
import nuricanozturk.dev.movie.save.dto.ExistsDTO;
import nuricanozturk.dev.movie.save.service.MovieSaveService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/movies/db/save")
public class MovieSaveServiceController
{
    private final MovieSaveService m_movieSaveService;

    public MovieSaveServiceController(MovieSaveService movieSaveService)
    {
        m_movieSaveService = movieSaveService;
    }

    @PostMapping("id")
    public ExistsDTO saveMovieById(@RequestParam("id") long id)
    {
        return m_movieSaveService.saveMovieById(id);
    }
}
