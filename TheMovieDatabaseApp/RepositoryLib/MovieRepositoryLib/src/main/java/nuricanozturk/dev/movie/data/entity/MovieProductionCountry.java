package nuricanozturk.dev.movie.data.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "movie_companies")
public class MovieProductionCountry
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long movie_country_id;

    @Column(nullable = false)
    private long movie_details_id;
    @Column(nullable = false)
    private long country_id;

    public MovieProductionCountry() {}

    public long getMovie_country_id()
    {
        return movie_country_id;
    }

    public void setMovie_country_id(long movie_country_id)
    {
        this.movie_country_id = movie_country_id;
    }

    public long getMovie_details_id()
    {
        return movie_details_id;
    }

    public void setMovie_details_id(long movie_details_id)
    {
        this.movie_details_id = movie_details_id;
    }

    public long getCountry_id()
    {
        return country_id;
    }

    public void setCountry_id(long country_id)
    {
        this.country_id = country_id;
    }
}
