package nuricanozturk.dev.dtolib.db.genericdtos;


public class ProductionCountryDTO
{
    private long country_id;

    private String name;

    public ProductionCountryDTO()
    {
    }

    public ProductionCountryDTO(String name)
    {
        this.name = name;
    }

    public ProductionCountryDTO(long country_id, String name)
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
