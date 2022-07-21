package com.company.internshipProject.Entity.MovieEntity;


import com.company.internshipProject.Entity.UserEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Movie")
public class Movie
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private int movieId;

    @Column(name = "real_movie_id", unique = true)
    private int realMovieId;

    @Column(name = "title")
    private String title;


    @OneToOne(
            cascade= CascadeType.ALL
    )
    @JoinColumn(name = "detail_id")
    private MovieDetail movieDetails;


    @ManyToMany
    @JoinTable(name = "movie_has_user",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<UserEntity> userEntities;




    public Movie()
    {

    }

    public Movie(int realMovieId, String title)
    {
        this.realMovieId = realMovieId;
        this.title = title;

    }



    public int getMovieId() {
        return movieId;
    }

    public int getRealMovieId() {
        return realMovieId;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MovieDetail getMovieDetails() {
        return movieDetails;
    }

    public void setMovieDetails(MovieDetail movieDetails) {
        this.movieDetails = movieDetails;
    }


    @Override
    public String toString() {
        return
                "id: " + getMovieId() + " RealId: " + getRealMovieId() + " Title: " + getTitle() +
                        "\n Overview: " + getMovieDetails().getOverview() + " Production: " + getMovieDetails().getProduction() +
                        " Genre: " + getMovieDetails().getGenre();
    }

}
