package nuricanozturk.dev.movie.data.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "movie_details")
public class MovieDetails
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long movie_detail_id;

    @Column(nullable = false, unique = true)
    private long real_movie_id;
    @Column(nullable = false)
    private String title;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "movieDetails", cascade = CascadeType.ALL)
    private List<ProductionCompany> companies;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "movieDetails", cascade = CascadeType.ALL)
    private List<ProductionCountry> countries;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "movieDetails", cascade = CascadeType.ALL)
    private List<Genre> genres;


    @Override
    public int hashCode()
    {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object other)
    {
        return other instanceof MovieDetails movieDetails && movieDetails.movie_detail_id == movie_detail_id;
    }
}
