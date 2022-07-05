package com.company.internshipProject.Dal.UserDal;

import com.company.internshipProject.Entity.Movie;
import com.company.internshipProject.Entity.Userr;

import java.util.List;

public interface IUserDal
{
    Userr getUserByUsername(String username);
    List<Userr> getAllUsers();
    Userr addUser(Userr userr);
    Movie addMovieToFavouriteList(Userr user,int id);
    List<Movie> getFavouriteMoviesByUsername(String username);
    String addToken(String token, String username);
    String getToken(String username);

    Movie deleteMovieFromFavouriteMovieList(Userr user, int movie_id);

}
