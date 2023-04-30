package nuricanozturk.dev.movie.data.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "movie_genres")
public class MovieGenres
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_genres_id", nullable = false)
    private long movie_genres_id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_detail_id", nullable = false)
    private MovieDetails movie_detail;
    @Column(name = "movie_genre_id", nullable = false)
    private long movie_genre_id;

    public MovieGenres()
    {
    }

    public MovieGenres(MovieDetails movie_detail, long movie_genre_id)
    {
        this.movie_detail = movie_detail;
        this.movie_genre_id = movie_genre_id;
    }

    public MovieDetails getMovie_detail()
    {
        return movie_detail;
    }

    public void setMovie_detail(MovieDetails movie_detail)
    {
        this.movie_detail = movie_detail;
    }

    public long getMovie_genre_id()
    {
        return movie_genre_id;
    }

    public void setMovie_genre_id(long movie_genre_id)
    {
        this.movie_genre_id = movie_genre_id;
    }

    public long getMovie_genres_id()
    {
        return movie_genres_id;
    }

    public void setMovie_genres_id(long movie_genres_id)
    {
        this.movie_genres_id = movie_genres_id;
    }

    public long getGenre_id()
    {
        return movie_genre_id;
    }

    public void setGenre_id(long genre_id)
    {
        this.movie_genre_id = genre_id;
    }
}
