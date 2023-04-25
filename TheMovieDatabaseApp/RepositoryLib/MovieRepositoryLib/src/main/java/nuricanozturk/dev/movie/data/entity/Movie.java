package nuricanozturk.dev.movie.data.entity;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "movie")
public record Movie(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "movie_id", nullable = false)
        long movie_id,
        @Column(name = "language", nullable = false)
        String language,
        @Column(name = "title", nullable = false)
        String title,
        @Column(name = "overview", nullable = false)
        String overview,
        @Column(name = "popularity", nullable = false)
        double popularity,
        @Column(name = "release_date", nullable = false)
        LocalDate release_date,
        @Column(name = "vote_average", nullable = false)
        double vote_average,
        @OneToOne(mappedBy = "movie", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        MovieDetails movieDetail

)
{
    public Movie()
    {
        this(0, "", "", "", 0.0, LocalDate.now(), 0.0);
    }
    public Movie(String language, String title, String overview, double popularity, LocalDate release_date, double vote_average)
    {
        this(0, language, title, overview, popularity, release_date, vote_average, null);
    }

    public Movie(long movie_id, String language, String title, String overview, double popularity, LocalDate release_date, double vote_average)
    {
        this(movie_id, language, title, overview, popularity, release_date, vote_average, null);
    }
}
