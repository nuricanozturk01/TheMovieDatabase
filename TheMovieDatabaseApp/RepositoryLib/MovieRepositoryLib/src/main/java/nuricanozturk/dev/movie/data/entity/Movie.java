package nuricanozturk.dev.movie.data.entity;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "movie")
public class Movie
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id", nullable = false)
    private long movie_id;
    @Column(name = "language", nullable = false)
    private String language;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "overview", nullable = false, length = 1000)
    private String overview;
    @Column(name = "popularity", nullable = false)
    private double popularity;
    @Column(name = "release_date", nullable = false)
    private LocalDate release_date;
    @Column(name = "vote_average", nullable = false)
    private double vote_average;
    @OneToOne(mappedBy = "movie", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_id")
    private MovieDetails movieDetail;

    public Movie() {}

    public Movie(String language, String title, String overview,
                 double popularity, LocalDate release_date, double vote_average)
    {
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

    public MovieDetails getMovieDetail()
    {
        return movieDetail;
    }

    public void setMovieDetail(MovieDetails movieDetail)
    {
        this.movieDetail = movieDetail;
    }
}
