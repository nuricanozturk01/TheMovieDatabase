package com.company.internshipProject.Service.UserService;

import com.company.internshipProject.Entity.JSONParser.TV.ResultOfTVSeries;
import com.company.internshipProject.Entity.MovieEntity.Movie;
import com.company.internshipProject.Entity.TVSeriesEntity.TVShow;
import com.company.internshipProject.Entity.UserEntity;

import java.util.List;

public interface IUserService
{
    UserEntity getUserByUsername(String username);
    List<UserEntity> getAllUsers();

    UserEntity addUser(UserEntity userEntity);

    boolean isUserExists(UserEntity userEntity);

    Movie addMovieToFavouriteList(int id);

    List<Movie> getFavouriteMoviesByUsername();

    String addToken(String token, String username);

    Movie deleteMovieFromFavouriteMovieList(int movie_id);


    TVShow addTvShowToFavouriteList(int id);
    List<TVShow> getFavouriteSeriesByUsername();
    TVShow deleteSeriesFromFavouriteMovieList(UserEntity user, int tv_show_id);

    void changePassword(UserEntity user);

}
