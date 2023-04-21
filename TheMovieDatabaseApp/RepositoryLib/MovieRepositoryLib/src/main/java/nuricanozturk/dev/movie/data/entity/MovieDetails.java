package nuricanozturk.dev.movie.data.entity;

import jakarta.persistence.*;

import java.util.List;
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "movieDetails", cascade = CascadeType.ALL)
    private List<ProductionCompany> companies;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "movieDetails", cascade = CascadeType.ALL)
    private List<ProductionCountry> countries;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "movieDetails", cascade = CascadeType.ALL)
    private List<Genre> genres;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;
    public MovieDetails() {}

    public MovieDetails(long movie_detail_id, long real_movie_id, String title)
    {
        this(real_movie_id, title);
        this.movie_detail_id = movie_detail_id;
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

    public List<ProductionCompany> getCompanies()
    {
        return companies;
    }

    public void setCompanies(List<ProductionCompany> companies)
    {
        this.companies = companies;
    }

    public List<ProductionCountry> getCountries()
    {
        return countries;
    }

    public void setCountries(List<ProductionCountry> countries)
    {
        this.countries = countries;
    }

    public List<Genre> getGenres()
    {
        return genres;
    }

    public void setGenres(List<Genre> genres)
    {
        this.genres = genres;
    }

    public Movie getMovie()
    {
        return movie;
    }

    public void setMovie(Movie movie)
    {
        this.movie = movie;
    }

    @Override
    public int hashCode()
    {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object other)
    {
        return other instanceof MovieDetails movieDetails && movieDetails.movie_detail_id == movie_detail_id;
    }
}
