package com.company.internshipProject.Controller;

import com.company.internshipProject.Entity.JSONParser.DetailForMovie.MovieDetail;
import com.company.internshipProject.Entity.JSONParser.MovieObject;
import com.company.internshipProject.Service.MovieAPIService.IMovieAPIService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController
{
    private IMovieAPIService apiService;

    @Autowired
    public MovieController(IMovieAPIService apiService)
    {
        this.apiService = apiService;
    }


    @GetMapping("/getAllMovies")
    public List<MovieObject> listMovies(@RequestParam(value = "page", defaultValue = "1") int pageNumber)
    {
        return apiService.getMovies(pageNumber);
    }


    @GetMapping("/getPopularMovies")
    public List<MovieObject> listPopularMovies(@RequestParam(value = "page", defaultValue = "1") int pageNumber)
    {
        return apiService.getPopularMovies(pageNumber);
    }


    @GetMapping("/getMovie")
    public MovieDetail getMovieByMovieId(@RequestParam(value = "id") int movie_id)
    {
        return apiService.getMovieDetail(movie_id);
    }


    @GetMapping("/search")
    public List<MovieObject> searchMovie(@RequestBody String title)
    {
        JSONObject obj = new JSONObject(title);
        return apiService.searchMovie(obj.getString("title"));
    }


}
