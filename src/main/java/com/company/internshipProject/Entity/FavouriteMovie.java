package com.company.internshipProject.Entity;

import javax.persistence.*;

@Entity
@Table(name = "favourite_movies")
public class FavouriteMovie
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "favourite_id")
    private int favouriteId;


    @OneToOne(mappedBy ="favouriteMovie")
    @JoinColumn(name = "favourite_id")
    private Movie movie;

    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="user_id")
    private Userr userr;

    public FavouriteMovie() {
    }

    public FavouriteMovie(Movie movie, Userr userr) {
        this.movie = movie;
        this.userr = userr;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Userr getUser() {
        return userr;
    }

    public void setUser(Userr userr) {
        this.userr = userr;
    }
}
