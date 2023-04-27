package nuricanozturk.dev.repository.generic.data.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "production_company")
public class ProductionCompany
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id", nullable = false)
    private long company_id;
    @Column(name = "company_name", nullable = false, unique = true)
    private String name;


    public ProductionCompany(){}
    public ProductionCompany(long company_id, String name)
    {
        this(name);
        this.company_id = company_id;

    }

    public ProductionCompany(String name)
    {
        this.name = name;
    }

    public long getCompany_id()
    {
        return company_id;
    }

    public void setCompany_id(long company_id)
    {
        this.company_id = company_id;
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
