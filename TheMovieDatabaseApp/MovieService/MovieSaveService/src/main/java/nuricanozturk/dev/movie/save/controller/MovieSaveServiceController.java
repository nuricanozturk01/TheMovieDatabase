package nuricanozturk.dev.movie.save.controller;

import nuricanozturk.dev.movie.save.dto.ExistsDTO;
import nuricanozturk.dev.movie.save.service.MovieSaveService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/movies/db/post")
public class MovieSaveServiceController
{
    private final MovieSaveService m_movieSaveService;

    public MovieSaveServiceController(MovieSaveService movieSaveService)
    {
        m_movieSaveService = movieSaveService;
    }

    @PostMapping("save/id")
    public ExistsDTO saveMovieById(@RequestParam("id") long id)
    {
        return m_movieSaveService.saveMovieById(id);
    }

    @DeleteMapping("remove/id")
    public ExistsDTO removeMovieById(@RequestParam("id") long id)
    {
        return m_movieSaveService.removeById(id);
    }
}
