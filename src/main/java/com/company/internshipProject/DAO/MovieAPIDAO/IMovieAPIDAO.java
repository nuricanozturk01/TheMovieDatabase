package com.company.internshipProject.DAO.MovieAPIDAO;

import com.company.internshipProject.Entity.JSONParser.DetailForMovie.MovieDetail;
import com.company.internshipProject.Entity.JSONParser.MovieObject;

import java.util.HashMap;
import java.util.List;
public interface IMovieAPIDAO
{

    List<MovieObject> getMovies(int pageNumber);


    MovieDetail getMovieDetail(int movie_id);


    List<MovieObject> getPopularMovies(int page);


    List<MovieObject> searchMovie(String title);


    HashMap<Integer, String> getGenres();
}
