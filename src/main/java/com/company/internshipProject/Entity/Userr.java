package com.company.internshipProject.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "User")
public class Userr
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
    @JoinTable( name = "movie_has_user",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "movie_id")
              )
    private List<Movie> movies;


    @OneToMany(fetch=FetchType.LAZY,
            mappedBy="userr",
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<FavouriteMovie> favouriteMovies;

    public Userr()
    {

    }

    public Userr(String username, String password)
    {
        this.username = username;
        this.password = password;
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

    public List<FavouriteMovie> getFavouriteMovies() {
        return favouriteMovies;
    }

    public void setFavouriteMovies(List<FavouriteMovie> favouriteMovies) {
        this.favouriteMovies = favouriteMovies;
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
    public void addFavouriteMovie(Movie movie)
    {
        if (favouriteMovies == null)
            favouriteMovies = new ArrayList<>();
        FavouriteMovie fav = new FavouriteMovie(movie,this);
        favouriteMovies.add(fav);
       // session.save(fav);
        //session.saveOrUpdate(this);
    }

    public void addFavouriteMovie(FavouriteMovie movie)
    {
        if (favouriteMovies == null)
            favouriteMovies = new ArrayList<>();
        favouriteMovies.add(movie);
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
