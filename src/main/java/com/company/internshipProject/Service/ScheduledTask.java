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
    private final MovieAPIService movieService;
    private final TVSeriesAPIService tvService;
    private final IUserService userService;

    public ScheduledTask(MovieAPIService movieService, TVSeriesAPIService tvService, IUserService userService) {
        this.movieService = movieService;
        this.tvService = tvService;
        this.userService = userService;
    }

    private String getPopularMoviesWithTitle(List<MovieObject> movies)
    {
        var popularMovies = new ArrayList<String>();

        movies.forEach(movie -> popularMovies.add("Title: " + movie.getTitle() + "       Avg. Vote: " + movie.getVote_average() + "\n"));

        var str = new StringBuilder();

        popularMovies.stream().map(movie -> movie + "\n").forEach(str::append);

        return str.toString();
    }

    private String getPopularTvSeriesWithTitle(List<ResultOfTVSeries> tvSeries)
    {
        var popularTvSeries = new ArrayList<String>();

        tvSeries.forEach(tv -> popularTvSeries.add("Title: " + tv.getOriginal_name() + "       Avg. Vote: " + tv.getVote_average() + "\n"));

        var str = new StringBuilder();

        popularTvSeries.stream().map(tv -> tv + "\n").forEach(str::append);

        return str.toString();
    }

    @Scheduled(cron="10 59 09 * * *")
    private void sendPopularMoviesToMembers()
    {
       if (userService.getAllUsers() == null)
           return;

       var movies = movieService.getPopularMovies(1);

       var str = getPopularMoviesWithTitle(movies);

       userService.getAllUsers().forEach(user -> Mail.sendMessage(user.getEmail(), "Popular Movies", str));
    }

    @Scheduled(cron="10 00 10 * * *")
    private void sendPopularTvShowsToMembers()
    {
        if (userService.getAllUsers() == null)
            return;

        var tvSeries = tvService.getPopularTvSeriesPageByPage(1);

        var str = getPopularTvSeriesWithTitle(tvSeries);

        userService.getAllUsers().forEach(user -> Mail.sendMessage(user.getEmail(), "Popular Tv Series", str));
    }
}
