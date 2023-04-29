package nuricanozturk.dev.movie.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;


@Entity
@Table(name = "movie_details")
public class MovieDetails
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_detail_id", nullable = false)
    private long movie_detail_id;

    @Column(name = "real_movie_id", nullable = false, unique = true)
    private long real_movie_id;
    @Column(name = "title", nullable = false)
    private String title;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    @JsonIgnore
    private Movie movie;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "movie_detail", cascade = CascadeType.ALL)
    private Set<MovieGenres> genres;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "movie_detail", cascade = CascadeType.ALL)
    private Set<MovieProductionCompany> productionCompanies;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "movie_detail", cascade = CascadeType.ALL)
    private Set<MovieProductionCountry> productionCountries;
    public MovieDetails() {}

    public MovieDetails(long movie_detail_id, long real_movie_id, String title)
    {
        this.movie_detail_id = movie_detail_id;
        this.real_movie_id = real_movie_id;
        this.title = title;

    }

    public MovieDetails(long real_movie_id, String title)
    {
        this.real_movie_id = real_movie_id;
        this.title = title;
    }

    public long getMovie_detail_id()
    {
        return movie_detail_id;
    }

    public void setMovie_detail_id(long movie_detail_id)
    {
        this.movie_detail_id = movie_detail_id;
    }

    public long getReal_movie_id()
    {
        return real_movie_id;
    }

    public void setReal_movie_id(long real_movie_id)
    {
        this.real_movie_id = real_movie_id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }



    public Movie getMovie()
    {
        return movie;
    }

    public void setMovie(Movie movie)
    {
        this.movie = movie;
    }

    public Set<MovieGenres> getGenres()
    {
        return genres;
    }

    public void setGenres(Set<MovieGenres> genres)
    {
        this.genres = genres;
    }

    public Set<MovieProductionCompany> getProductionCompanies()
    {
        return productionCompanies;
    }

    public void setProductionCompanies(Set<MovieProductionCompany> productionCompanies)
    {
        this.productionCompanies = productionCompanies;
    }

    public Set<MovieProductionCountry> getProductionCountries()
    {
        return productionCountries;
    }

    public void setProductionCountries(Set<MovieProductionCountry> productionCountries)
    {
        this.productionCountries = productionCountries;
    }

    @Override
    public int hashCode()
    {
        return Long.hashCode(movie_detail_id);
    }


    @Override
    public boolean equals(Object other)
    {
        return other instanceof MovieDetails movieDetails && movieDetails.movie_detail_id == movie_detail_id;
    }
}
