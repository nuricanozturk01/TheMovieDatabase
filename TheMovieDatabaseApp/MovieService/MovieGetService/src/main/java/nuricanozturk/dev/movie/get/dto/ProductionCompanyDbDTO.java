package nuricanozturk.dev.movie.get.dto;
public class ProductionCompanyDbDTO
{
    private long company_id;
    private String name;

    public ProductionCompanyDbDTO() {}

    public ProductionCompanyDbDTO(long company_id, String name)
    {
        this.company_id = company_id;
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
