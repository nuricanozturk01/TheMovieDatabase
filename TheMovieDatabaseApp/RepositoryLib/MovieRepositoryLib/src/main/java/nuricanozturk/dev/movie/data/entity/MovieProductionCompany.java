package nuricanozturk.dev.movie.data.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "movie_companies")
public class MovieProductionCompany
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_company_id", nullable = false)
    private long movie_company_id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_detail_id", nullable = false)
    private MovieDetails movie_detail;
    @Column(name = "company_id", nullable = false)
    private long company_id;

    public MovieProductionCompany()
    {
    }

    public MovieProductionCompany(MovieDetails movie_details_id, long company_id)
    {
        this.movie_detail = movie_details_id;
        this.company_id = company_id;
    }

    public MovieDetails getMovie_detail()
    {
        return movie_detail;
    }

    public void setMovie_detail(MovieDetails movie_details_id)
    {
        this.movie_detail = movie_details_id;
    }

    public long getMovie_company_id()
    {
        return movie_company_id;
    }

    public void setMovie_company_id(long movie_company_id)
    {
        this.movie_company_id = movie_company_id;
    }

    public long getCompany_id()
    {
        return company_id;
    }

    public void setCompany_id(long company_id)
    {
        this.company_id = company_id;
    }
}
