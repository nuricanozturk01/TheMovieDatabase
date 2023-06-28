package nuricanozturk.dev.dtolib.entity.api.movie;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ProductionCompany
{
    public int id;
    @JsonIgnore
    public String logo_path;
    public String name;
    @JsonIgnore
    public String origin_country;
}