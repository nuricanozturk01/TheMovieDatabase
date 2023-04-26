package nuricanozturk.dev.movie.data.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "movie_companies")
public class MovieProductionCompany
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long movie_company_id;

    @Column(nullable = false)
    private long movie_details_id;
    @Column(nullable = false)
    private long company_id;

    public MovieProductionCompany() {}

    public long getMovie_company_id()
    {
        return movie_company_id;
    }

    public void setMovie_company_id(long movie_company_id)
    {
        this.movie_company_id = movie_company_id;
    }

    public long getMovie_details_id()
    {
        return movie_details_id;
    }

    public void setMovie_details_id(long movie_details_id)
    {
        this.movie_details_id = movie_details_id;
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
