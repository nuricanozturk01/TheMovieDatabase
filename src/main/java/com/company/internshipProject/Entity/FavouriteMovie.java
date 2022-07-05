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
    private UserEntity userEntity;

    public FavouriteMovie() {
    }

    public FavouriteMovie(Movie movie, UserEntity userEntity) {
        this.movie = movie;
        this.userEntity = userEntity;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public UserEntity getUser() {
        return userEntity;
    }

    public void setUser(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
