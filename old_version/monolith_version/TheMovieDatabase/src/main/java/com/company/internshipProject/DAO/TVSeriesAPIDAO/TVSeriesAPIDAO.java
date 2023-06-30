package com.company.internshipProject.DAO.TVSeriesAPIDAO;

import com.company.internshipProject.Entity.JSONParser.TV.DetailOfTV;
import com.company.internshipProject.Entity.JSONParser.TV.ResultOfTVSeries;
import com.company.internshipProject.Entity.JSONParser.TV.RootOfTVSeries;
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
import java.util.List;


@Repository
public class TVSeriesAPIDAO implements ITVSeriesAPIDAO{

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
    public DetailOfTV getDetail(int tv_id)
    {
        try
        {
            var response =
                    getResponse("https://api.themoviedb.org/3/tv/"+tv_id+"?api_key="+ API_KEY);
            var mapper = new ObjectMapper();

            return mapper.readValue(response.body(), DetailOfTV.class);

        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<ResultOfTVSeries> getTvSeriesPageByPage(int page_number)
    {
        var series = new ArrayList<ResultOfTVSeries>();

        try
        {
            String query =
                    "https://api.themoviedb.org/3/discover/tv?api_key="+ API_KEY +
                            "&sort_by=popularity.desc&page="+page_number+"&include_null_first_air_dates=false" +
                            "&with_watch_monetization_types=flatrate&with_status=0&with_type=0";

            HttpResponse<String> response = getResponse(query);

            ObjectMapper mapper = new ObjectMapper();

            RootOfTVSeries root = mapper.readValue(response.body(),RootOfTVSeries.class);

            series.addAll(root.getResults());
        }
        catch (JsonProcessingException e)
        {
            throw new RuntimeException(e);
        }

        return series;
    }

    @Override
    public List<ResultOfTVSeries> getPopularTvSeriesPageByPage(int page_number)
    {
        List<ResultOfTVSeries> popularTVSeries;
        try
        {
            var response =
                    getResponse("https://api.themoviedb.org/3/tv/popular?api_key="+API_KEY+"&page=" + page_number);
            var mapper = new ObjectMapper();
            var result  = mapper.readValue(response.body(),RootOfTVSeries.class);
            popularTVSeries = new ArrayList<>(result.getResults());

        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        return popularTVSeries;
    }

    @Override
    public List<ResultOfTVSeries> searchTvShow(String title) {
        List<ResultOfTVSeries> tvSeries;
        try
        {
            title = title.replaceAll(" ", "%20");
            var str =
                "https://api.themoviedb.org/3/search/tv?api_key=" + API_KEY +
                        "&language=en-US&page=1&query=" + title;
            var response = getResponse(str);
            var mapper = new ObjectMapper();
            var result  = mapper.readValue(response.body(),RootOfTVSeries.class);
            tvSeries = new ArrayList<>(result.getResults());
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        return tvSeries;
    }


}
