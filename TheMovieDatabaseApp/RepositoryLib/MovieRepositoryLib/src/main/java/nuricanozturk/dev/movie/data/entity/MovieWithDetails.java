package nuricanozturk.dev.movie.data.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.List;

public class MovieWithDetails
{
    public long movie_id;
    public String language;
    public String title;
    public String overview;
    public double popularity;
    public LocalDate release_date;
    public double vote_average;
    public long real_movie_id;
    public List<ProductionCompany> companies;

    public List<ProductionCountry> countries;

    public List<Genre> genres;

    public MovieWithDetails()
    {
    }

    public MovieWithDetails(long movie_id, String language, String title, String overview, double popularity, LocalDate release_date, double vote_average, long real_movie_id, List<ProductionCompany> companies, List<ProductionCountry> countries, List<Genre> genres)
    {
        this.movie_id = movie_id;
        this.language = language;
        this.title = title;
        this.overview = overview;
        this.popularity = popularity;
        this.release_date = release_date;
        this.vote_average = vote_average;
        this.real_movie_id = real_movie_id;
        this.companies = companies;
        this.countries = countries;
        this.genres = genres;
    }
}
