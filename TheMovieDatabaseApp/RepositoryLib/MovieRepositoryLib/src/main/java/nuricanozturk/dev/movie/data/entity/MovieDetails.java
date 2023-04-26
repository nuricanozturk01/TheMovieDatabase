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

    @Column(name = "company_id", nullable = false)
    private int company;

    @Column(name = "country_id", nullable = false)
    private int country;

    @Column(name = "genre_id", nullable = false)
    private int genre;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id")
    private MovieGenres genres;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private MovieProductionCompany productionCompanies;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private MovieProductionCompany productionCountries;
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

    public int getCompany()
    {
        return company;
    }

    public void setCompany(int company)
    {
        this.company = company;
    }

    public int getCountry()
    {
        return country;
    }

    public void setCountry(int country)
    {
        this.country = country;
    }

    public int getGenre()
    {
        return genre;
    }

    public void setGenre(int genre)
    {
        this.genre = genre;
    }

    public Movie getMovie()
    {
        return movie;
    }

    public void setMovie(Movie movie)
    {
        this.movie = movie;
    }

    public MovieGenres getGenres()
    {
        return genres;
    }

    public void setGenres(MovieGenres genres)
    {
        this.genres = genres;
    }

    public MovieProductionCompany getProductionCompanies()
    {
        return productionCompanies;
    }

    public void setProductionCompanies(MovieProductionCompany productionCompanies)
    {
        this.productionCompanies = productionCompanies;
    }

    public MovieProductionCompany getProductionCountries()
    {
        return productionCountries;
    }

    public void setProductionCountries(MovieProductionCompany productionCountries)
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
