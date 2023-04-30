package nuricanozturk.dev.repository.generic.data.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "production_country")
public class ProductionCountry
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id", nullable = false)
    private long country_id;
    @Column(name = "country_name", nullable = false, unique = true)
    private String name;

    public ProductionCountry()
    {
    }

    public ProductionCountry(String name)
    {
        this.name = name;
    }

    public ProductionCountry(long country_id, String name)
    {
        this.country_id = country_id;
        this.name = name;
    }

    public long getCountry_id()
    {
        return country_id;
    }

    public void setCountry_id(long country_id)
    {
        this.country_id = country_id;
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
