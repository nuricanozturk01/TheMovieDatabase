package nuricanozturk.dev.movie.get.dto;

public class ProductionCountryDbDTO
{
    private long country_id;
    private String name;

    public ProductionCountryDbDTO()
    {
    }

    public ProductionCountryDbDTO(long country_id, String name)
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
