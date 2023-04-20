package nuricanozturk.dev.movie.data.entity;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "movie")
public class Movie
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long movie_id;
    @Column(nullable = false)
    private String language;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String overview;
    @Column(nullable = false)
    private double popularity;
    @Column(nullable = false)
    private LocalDate release_date;
    @Column(nullable = false)
    private double vote_average;

    /*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_detail_id", referencedColumnName = "id")
    private MovieDetails movieDetail;*/

    public Movie() {}

    public Movie(long movie_id, String language, String title, String overview, double popularity, LocalDate release_date, double vote_average)
    {
        this.movie_id = movie_id;
        this.language = language;
        this.title = title;
        this.overview = overview;
        this.popularity = popularity;
        this.release_date = release_date;
        this.vote_average = vote_average;
    }

    public long getMovie_id()
    {
        return movie_id;
    }

    public void setMovie_id(long movie_id)
    {
        this.movie_id = movie_id;
    }

    public String getLanguage()
    {
        return language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getOverview()
    {
        return overview;
    }

    public void setOverview(String overview)
    {
        this.overview = overview;
    }

    public double getPopularity()
    {
        return popularity;
    }

    public void setPopularity(double popularity)
    {
        this.popularity = popularity;
    }

    public LocalDate getRelease_date()
    {
        return release_date;
    }

    public void setRelease_date(LocalDate release_date)
    {
        this.release_date = release_date;
    }

    public double getVote_average()
    {
        return vote_average;
    }

    public void setVote_average(double vote_average)
    {
        this.vote_average = vote_average;
    }
}
