package com.company.internshipProject.DAO.MovieAPIDAO;

import com.company.internshipProject.Entity.JSONParser.DetailForMovie.MovieDetail;
import com.company.internshipProject.Entity.JSONParser.Genre.GenreRoot;
import com.company.internshipProject.Entity.JSONParser.MovieObject;
import com.company.internshipProject.Entity.JSONParser.Root;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Repository
public class MovieAPIDAO implements IMovieAPIDAO
{
    private HttpClient client;
    private final String API_KEY = "6b46471fb8db6037924a858de17ed116";

    @PostConstruct
    private void createClient()
    {
        client = HttpClient.newHttpClient();
    }

    private HttpResponse<String> getResponse(String query)
    {
        try
        {
            var request = HttpRequest.newBuilder()
                    .uri(URI.create(query))
                    .build();

            return client.send(request,
                    HttpResponse.BodyHandlers.ofString());
        }
        catch (IOException | InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }





    @Override
    public List<MovieObject> getMovies(int pageNumber)
    {
        var movies = new ArrayList<MovieObject>();

        try
        {
            var query = "https://api.themoviedb.org/3/discover/movie?api_key" +
                    "=" + API_KEY + "&include_adult=true&include_video=false&page=" + pageNumber;

            var response = getResponse(query);

            var mapper = new ObjectMapper();

            var root = mapper.readValue(response.body(),Root.class);

            movies.addAll(root.getResults());
        }
        catch (JsonProcessingException e)
        {
            throw new RuntimeException(e);
        }
        return movies;
    }


    @Override
    public MovieDetail getMovieDetail(int movie_id)
    {
        try
        {
            var response =
                    getResponse("https://api.themoviedb.org/3/movie/"+movie_id+"?api_key="+ API_KEY);
            var mapper = new ObjectMapper();

            return mapper.readValue(response.body(), MovieDetail.class);

        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<MovieObject> getPopularMovies(int page)
    {
        List<MovieObject> popularMovies;
        try
        {
            var response =
                    getResponse("https://api.themoviedb.org/3/movie/popular?api_key="+API_KEY+"&page=" + page);
            var mapper = new ObjectMapper();
            var result  = mapper.readValue(response.body(),Root.class);
            popularMovies = new ArrayList<>(result.getResults());

        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        return popularMovies;
    }

    @Override
    public List<MovieObject> searchMovie(String title)
    {
        List<MovieObject> popularMovies;
        try
        {
            title = title.replaceAll(" ", "%20");
            var str =
                    "https://api.themoviedb.org/3/search/movie?api_key="+API_KEY+
                            "&query="+title+"&page=1&include_adult=false";
            var response = getResponse(str);
            var mapper = new ObjectMapper();
            var result  = mapper.readValue(response.body(),Root.class);
            popularMovies = new ArrayList<>(result.getResults());

        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        return popularMovies;
    }

    @Override
    public HashMap<Integer, String> getGenres()
    {
        var genres = new HashMap<Integer, String>();
        try
        {

            var str =
                "https://api.themoviedb.org/3/genre/movie/list?api_key="+API_KEY+"&language=en-US";
            var response = getResponse(str);
            var mapper = new ObjectMapper();

            var result  = mapper.readValue(response.body(),GenreRoot.class);

            for (int i = 0; i < result.getGenres().size(); i++)
                genres.put(result.getGenres().get(i).getId(),
                        result.getGenres().get(i).getName());
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        return genres;
    }
}
