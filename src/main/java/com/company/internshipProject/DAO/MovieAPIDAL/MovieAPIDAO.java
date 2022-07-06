package com.company.internshipProject.DAO.MovieAPIDAL;

import com.company.internshipProject.Entity.JSONParser.Detail.Detail;
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
            HttpRequest request = HttpRequest.newBuilder()
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
        List<MovieObject> movies = new ArrayList<>();

        try
        {
            String query = "https://api.themoviedb.org/3/discover/movie?api_key" +
                    "=" + API_KEY + "&include_adult=true&include_video=false&page=" + pageNumber;

            HttpResponse<String> response = getResponse(query);

            ObjectMapper mapper = new ObjectMapper();

            Root root = mapper.readValue(response.body(),Root.class);

            movies.addAll(root.getResults());
        }
        catch (JsonProcessingException e)
        {
            throw new RuntimeException(e);
        }
        return movies;
    }


    @Override
    public Detail getMovieDetail(int movie_id)
    {
        try
        {
            HttpResponse<String> response =
                    getResponse("https://api.themoviedb.org/3/movie/"+movie_id+"?api_key="+ API_KEY);
            ObjectMapper mapper = new ObjectMapper();

            return mapper.readValue(response.body(),Detail.class);

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
            HttpResponse<String> response =
                    getResponse("https://api.themoviedb.org/3/movie/popular?api_key="+API_KEY+"&page=" + page);
            ObjectMapper mapper = new ObjectMapper();
            Root result  = mapper.readValue(response.body(),Root.class);
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
            String str =
                    "https://api.themoviedb.org/3/search/movie?api_key="+API_KEY+
                            "&query="+title+"&page=1&include_adult=false";
            HttpResponse<String> response = getResponse(str);
            ObjectMapper mapper = new ObjectMapper();
            Root result  = mapper.readValue(response.body(),Root.class);
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
        HashMap<Integer, String> genres = new HashMap<>();
        try
        {

            String str =
                "https://api.themoviedb.org/3/genre/movie/list?api_key="+API_KEY+"&language=en-US";
            HttpResponse<String> response = getResponse(str);
            ObjectMapper mapper = new ObjectMapper();

            GenreRoot result  = mapper.readValue(response.body(),GenreRoot.class);

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
