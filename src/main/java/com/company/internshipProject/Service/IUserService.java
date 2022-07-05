package com.company.internshipProject.Service;

import com.company.internshipProject.Entity.Movie;
import com.company.internshipProject.Entity.Userr;

import java.util.List;

public interface IUserService
{
    Userr getUserByUsername(String username);
    List<Userr> getAllUsers();

    Userr addUser(Userr userr);

    boolean isUserExists(Userr userr);

    Movie addMovieToFavouriteList(Userr user,int id);

    List<Movie> getFavouriteMoviesByUsername(String username);

    String addToken(String token, String username);

    Movie deleteMovieFromFavouriteMovieList(Userr user, int movie_id);

}
