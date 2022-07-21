package com.company.internshipProject.Service;

import com.company.internshipProject.Entity.JSONParser.MovieObject;
import com.company.internshipProject.Entity.JSONParser.TV.ResultOfTVSeries;
import com.company.internshipProject.Service.MovieAPIService.MovieAPIService;
import com.company.internshipProject.Service.TVSeriesAPIService.TVSeriesAPIService;
import com.company.internshipProject.Service.UserService.IUserService;
import com.company.internshipProject.util.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@EnableScheduling
@Component
public class ScheduledTask
{

    @Autowired
    private MovieAPIService movieService;

    @Autowired
    private TVSeriesAPIService tvService;

    @Autowired
    private IUserService userService;

    public ScheduledTask(MovieAPIService movieService, TVSeriesAPIService tvService, IUserService userService) {
        this.movieService = movieService;
        this.tvService = tvService;
        this.userService = userService;
    }

    private String getPopularMoviesWithTitle(List<MovieObject> movies)
    {
        List<String> popularMovies = new ArrayList<>();

        for (MovieObject movie : movies)
            popularMovies.add("Title: " + movie.getTitle() + "       Avg. Vote: " + movie.getVote_average() + "\n");

        StringBuilder str = new StringBuilder();
        for (String popularMovie : popularMovies)
            str.append(popularMovie).append("\n");

        return str.toString();
    }

    private String getPopularTvSeriesWithTitle(List<ResultOfTVSeries> tvSeries)
    {
        List<String> popularTvSeries = new ArrayList<>();

        for (ResultOfTVSeries tv : tvSeries)
            popularTvSeries.add("Title: " + tv.getOriginal_name() + "       Avg. Vote: " + tv.getVote_average() + "\n");

        StringBuilder str = new StringBuilder();
        for (String popularMovie : popularTvSeries)
            str.append(popularMovie).append("\n");

        return str.toString();
    }

















    @Scheduled(cron="10 40 19 * * *")
    private void sendPopularMoviesToMembers()
    {
       if (userService.getAllUsers() == null)
           return;

       List<MovieObject> movies = movieService.getPopularMovies(1);

       String str = getPopularMoviesWithTitle(movies);

        for (int i = 0; i < userService.getAllUsers().size(); i++)
            Mail.sendMessage(userService.getAllUsers().get(i).getEmail(),"Popular Movies",str);
    }

    @Scheduled(cron="10 43 19 * * *")
    private void sendPopularTvShowsToMembers()
    {
        if (userService.getAllUsers() == null)
            return;

        List<ResultOfTVSeries> tvSeries = tvService.getPopularTvSeriesPageByPage(1);

        String str = getPopularTvSeriesWithTitle(tvSeries);

        for (int i = 0; i < userService.getAllUsers().size(); i++)
            Mail.sendMessage(userService.getAllUsers().get(i).getEmail(),"Popular Tv Series",str);
    }
}
