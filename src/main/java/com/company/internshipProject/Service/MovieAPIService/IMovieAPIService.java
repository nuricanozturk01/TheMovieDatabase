package com.company.internshipProject.Service.MovieAPIService;

import com.company.internshipProject.Entity.JSONParser.Detail.Detail;
import com.company.internshipProject.Entity.JSONParser.MovieObject;

import java.util.HashMap;
import java.util.List;

public interface IMovieAPIService
{
    List<MovieObject> getMovies(int pageNumber);
    Detail getMovieDetail(int movie_id);
    List<MovieObject> getPopularMovies(int page);

    List<MovieObject> searchMovie(String title);

    HashMap<Integer, String> getGenres();
}
