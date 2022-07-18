package com.company.internshipProject.Entity;

import com.company.internshipProject.Entity.MovieEntity.Movie;
import com.company.internshipProject.Entity.TVSeriesEntity.TVShow;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "User")
public class UserEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "token")
    private String token;

    @ManyToMany
    @JoinTable(
            name = "user_has_tv",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "tv_show_id")
    )
    private List<TVShow> tvShows;
    @ManyToMany
    @JoinTable( name = "movie_has_user",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "movie_id")
              )
    private List<Movie> movies;



    public UserEntity()
    {

    }

    public UserEntity(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    public List<TVShow> getTvShows() {
        return tvShows;
    }

    public void setTvShows(List<TVShow> tvShows) {
        this.tvShows = tvShows;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void addMovie(Movie movie)
    {
        if (movies == null)
            movies = new ArrayList<>();
        movies.add(movie);
    }


    public void addTvShow(TVShow tv)
    {
        if (tvShows == null)
            tvShows = new ArrayList<>();
        tvShows.add(tv);
    }


    @Override
    public String toString()
    {
        return
                "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}'+"\n\n";
    }

}
