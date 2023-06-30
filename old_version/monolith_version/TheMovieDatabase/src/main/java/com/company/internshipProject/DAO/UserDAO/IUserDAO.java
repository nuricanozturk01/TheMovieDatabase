package com.company.internshipProject.DAO.UserDAO;

import com.company.internshipProject.Entity.JSONParser.TV.ResultOfTVSeries;
import com.company.internshipProject.Entity.MovieEntity.Movie;
import com.company.internshipProject.Entity.TVSeriesEntity.TVShow;
import com.company.internshipProject.Entity.UserEntity;

import java.util.List;

public interface IUserDAO
{
    UserEntity getUserByUsername(String username);
    List<UserEntity> getAllUsers();
    UserEntity addUser(UserEntity userEntity);
    Movie addMovieToFavouriteList(UserEntity user, int id);
    List<Movie> getFavouriteMoviesByUsername(UserEntity user);
    String addToken(String token, String username);
    String getToken(String username);
    Movie deleteMovieFromFavouriteMovieList(UserEntity user, int movie_id);
    TVShow addTvShowToFavouriteList(UserEntity user, int id);
    List<TVShow> getFavouriteSeriesByUsername(UserEntity user);
    TVShow deleteSeriesFromFavouriteMovieList(UserEntity user, int tv_show_id);
    void updateUser(UserEntity user, String hashedPassword);
}
