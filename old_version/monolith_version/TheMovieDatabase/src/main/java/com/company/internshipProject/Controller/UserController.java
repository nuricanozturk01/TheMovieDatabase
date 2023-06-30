package com.company.internshipProject.Controller;

import com.company.internshipProject.Entity.MovieEntity.Movie;
import com.company.internshipProject.Entity.TVSeriesEntity.TVShow;
import com.company.internshipProject.Service.UserService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController
{
    private IUserService service;

    @Autowired
    public UserController(IUserService service) {
        this.service = service;
    }


    @PostMapping("/movie/addFavouriteList")
    public Movie addMovieToFavouriteList(@RequestParam int id)
    {
        return service.addMovieToFavouriteList(id);
    }

    @GetMapping("/movie/getFavouriteList")
    public List<Movie> getFavouriteMovies()
    {
        return service.getFavouriteMoviesByUsername();
    }

    @PostMapping("/movie/delete")
    public Movie deleteMovieFromFavouriteList(@RequestParam(name = "id") int id)
    {
        return service.deleteMovieFromFavouriteMovieList(id);
    }

    @PostMapping("/tv/addFavouriteList")
    public TVShow addTVShowToFavouriteList(@RequestParam int id)
    {
        return service.addTvShowToFavouriteList(id);
    }

    @GetMapping("/tv/getFavouriteList")
    public List<TVShow> getFavouriteTVShows()
    {
        return service.getFavouriteSeriesByUsername();
    }
}
