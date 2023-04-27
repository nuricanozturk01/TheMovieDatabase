package nuricanozturk.dev.movie.data.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "movie_countries")
public class MovieProductionCountry
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_country_id", nullable = false)
    private long movie_country_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_detail_id", nullable = false)
    private MovieDetails movie_detail;
    @Column(name = "country_id", nullable = false)
    private long country_id;

    public MovieProductionCountry() {}

    public MovieProductionCountry(MovieDetails movie_details_id, long country_id)
    {
        this.movie_detail = movie_details_id;
        this.country_id = country_id;
    }

    public MovieDetails getMovie_detail()
    {
        return movie_detail;
    }

    public void setMovie_detail(MovieDetails movie_detail)
    {
        this.movie_detail = movie_detail;
    }

    public long getMovie_country_id()
    {
        return movie_country_id;
    }

    public void setMovie_country_id(long movie_country_id)
    {
        this.movie_country_id = movie_country_id;
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
