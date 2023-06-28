package nuricanozturk.dev.dtolib.entity.api.movie;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ProductionCountry
{
    @JsonIgnore
    public String iso_3166_1;
    public String name;
}