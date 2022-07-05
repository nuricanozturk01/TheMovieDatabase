package com.company.internshipProject.Controller;

import com.company.internshipProject.Entity.Movie;
import com.company.internshipProject.Entity.UserEntity;
import com.company.internshipProject.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController
{
    private IUserService service;

    @Autowired
    public UserController(IUserService service) {
        this.service = service;
    }

    @GetMapping("/getUser/{username}")
    public UserEntity getUser(@PathVariable String username)
    {
        return service.getUserByUsername(username);
    }



    @GetMapping("/getUsers")
    public List<UserEntity> getUsers()
    {
        return service.getAllUsers();
    }


    @PostMapping("/addFavouriteList/{id}")
    public Movie addMovieToFavouriteList(@RequestBody UserEntity user, @PathVariable int id)
    {
        return service.addMovieToFavouriteList(user,id);
    }

    @GetMapping("/getFavouriteMovies/{username}")
    public List<Movie> getFavouriteMovies(@PathVariable String username)
    {
        return service.getFavouriteMoviesByUsername(username);
    }

    @PostMapping("/delete/{id}")
    public Movie deleteMovieFromFavouriteList(@PathVariable int id, @RequestBody UserEntity user)
    {
        return service.deleteMovieFromFavouriteMovieList(user, id);
    }

}
