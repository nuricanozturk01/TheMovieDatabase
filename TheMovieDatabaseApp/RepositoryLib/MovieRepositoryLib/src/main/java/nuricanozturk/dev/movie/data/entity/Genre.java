package nuricanozturk.dev.movie.data.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "genre")
public class Genre
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id", nullable = false)
    private long genre_id;
    @Column(name = "genre_name", nullable = false, unique = true)
    private String name;

    @ManyToOne
    public MovieDetails movieDetails;

    public Genre(){}

    public Genre(long genre_id, String name)
    {
        this.genre_id = genre_id;
        this.name = name;
    }

    public Genre(String name)
    {
        this.name = name;
    }

    public long getGenre_id()
    {
        return genre_id;
    }

    public void setGenre_id(long genre_id)
    {
        this.genre_id = genre_id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
