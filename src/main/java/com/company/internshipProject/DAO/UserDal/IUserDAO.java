package com.company.internshipProject.DAO.UserDal;

import com.company.internshipProject.Entity.Movie;
import com.company.internshipProject.Entity.UserEntity;

import java.util.List;

public interface IUserDAO
{
    UserEntity getUserByUsername(String username);
    List<UserEntity> getAllUsers();
    UserEntity addUser(UserEntity userEntity);
    Movie addMovieToFavouriteList(UserEntity user, int id);
    List<Movie> getFavouriteMoviesByUsername(String username);
    String addToken(String token, String username);
    String getToken(String username);

    Movie deleteMovieFromFavouriteMovieList(UserEntity user, int movie_id);

}
