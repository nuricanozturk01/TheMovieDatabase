package com.company.internshipProject.Service.MovieAPIService;

import com.company.internshipProject.Dal.MovieAPIDAL.IMovieAPIDal;
import com.company.internshipProject.Entity.JSONParser.Detail.Detail;
import com.company.internshipProject.Entity.JSONParser.MovieObject;
import com.company.internshipProject.Exceptions.MovieExceptions.InvalidMovieIdException;
import com.company.internshipProject.Exceptions.MovieExceptions.InvalidPageNumberException;
import com.company.internshipProject.Exceptions.MovieExceptions.MovieNotExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;


@Service
public class MovieAPIService implements IMovieAPIService
{

    private IMovieAPIDal movieAPIDal;

    @Autowired
    public MovieAPIService(IMovieAPIDal movieAPIDal)
    {
        this.movieAPIDal = movieAPIDal;
    }

    @Override
    public Detail getMovieDetail(int movie_id)
    {
        if (movie_id < 0 || movie_id > Integer.MAX_VALUE)
            throw new InvalidMovieIdException();

        return movieAPIDal.getMovieDetail(movie_id);
    }

    @Override
    public List<MovieObject> getPopularMovies(int page)
    {
        if (page < 0 || page > Integer.MAX_VALUE)
            throw new InvalidPageNumberException();
        return movieAPIDal.getPopularMovies(page);
    }

    @Override
    public List<MovieObject> searchMovie(String title)
    {
        if (title.isEmpty() || title.isBlank())
            throw new MovieNotExistsException();

        return movieAPIDal.searchMovie(title);
    }

    @Override
    public HashMap<Integer, String> getGenres()
    {
        return movieAPIDal.getGenres();
    }


    @Override
    public List<MovieObject> getMovies(int pageNumber)
    {
        if (pageNumber < 0 || pageNumber > Integer.MAX_VALUE)
            throw new InvalidPageNumberException();
        return movieAPIDal.getMovies(pageNumber);
    }


}
