package nuricanozturk.dev.repository.generic.data.entity;

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


    public Genre(){}

    public Genre(String name, long genre_id)
    {
        this.name = name;
        this.genre_id = genre_id;
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
