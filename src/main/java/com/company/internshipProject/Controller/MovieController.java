package com.company.internshipProject.Controller;

import com.company.internshipProject.Entity.JSONParser.Detail.Detail;
import com.company.internshipProject.Entity.JSONParser.MovieObject;
import com.company.internshipProject.Service.MovieAPIService.IMovieAPIService;
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


    @GetMapping("/getAllMovies/{pageNumber}")
    public List<MovieObject> listMovies(@PathVariable int pageNumber)
    {
        return apiService.getMovies(pageNumber);
    }


    @GetMapping("/getPopularMovies/{pageNumber}")
    public List<MovieObject> listPopularMovies(@PathVariable int pageNumber)
    {
        return apiService.getPopularMovies(pageNumber);
    }


    @GetMapping("/getMovie/{movie_id}")
    public Detail getMovieByMovieId(@PathVariable int movie_id)
    {
        return apiService.getMovieDetail(movie_id);
    }


    @GetMapping("/search/{title}")
    public List<MovieObject> searchMovie(@PathVariable String title)
    {
        return apiService.searchMovie(title);
    }


}
