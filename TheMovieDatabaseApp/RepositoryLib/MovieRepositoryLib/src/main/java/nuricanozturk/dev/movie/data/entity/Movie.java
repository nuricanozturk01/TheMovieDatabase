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
    @Column(name = "overview", nullable = false)
    private String overview;
    @Column(name = "popularity", nullable = false)
    private double popularity;
    @Column(name = "release_date", nullable = false)
    private LocalDate release_date;
    @Column(name = "vote_average", nullable = false)
    private double vote_average;
    @OneToOne(mappedBy = "movie", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private MovieDetails movieDetail;

    public Movie() {}

    public Movie(long movie_id, String language, String title, String overview,
                 double popularity, LocalDate release_date, double vote_average, MovieDetails movieDetail)
    {
        this.movie_id = movie_id;
        this.language = language;
        this.title = title;
        this.overview = overview;
        this.popularity = popularity;
        this.release_date = release_date;
        this.vote_average = vote_average;
        this.movieDetail = movieDetail;
    }
}
