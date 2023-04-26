package nuricanozturk.dev.movie.data.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "movie_genres")
public class MovieGenres
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long movie_genres_id;

    @Column(nullable = false)
    private long movie_details_id;
    @Column(nullable = false)
    private long genre_id;

    public MovieGenres() {}

    public MovieGenres(long movie_genres_id, long movie_details_id, long genre_id)
    {
        this.movie_genres_id = movie_genres_id;
        this.movie_details_id = movie_details_id;
        this.genre_id = genre_id;
    }

    public long getMovie_genres_id()
    {
        return movie_genres_id;
    }

    public void setMovie_genres_id(long movie_genres_id)
    {
        this.movie_genres_id = movie_genres_id;
    }

    public long getMovie_details_id()
    {
        return movie_details_id;
    }

    public void setMovie_details_id(long movie_details_id)
    {
        this.movie_details_id = movie_details_id;
    }

    public long getGenre_id()
    {
        return genre_id;
    }

    public void setGenre_id(long genre_id)
    {
        this.genre_id = genre_id;
    }
}
