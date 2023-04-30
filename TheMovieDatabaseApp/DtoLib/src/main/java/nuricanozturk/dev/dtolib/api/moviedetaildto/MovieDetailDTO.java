package nuricanozturk.dev.dtolib.api.moviedetaildto;

import com.fasterxml.jackson.annotation.JsonProperty;
import nuricanozturk.dev.dtolib.api.genredto.GenreDTO;
import nuricanozturk.dev.dtolib.api.productioncompanydto.ProductionCompanyDTO;
import nuricanozturk.dev.dtolib.api.productioncountrydto.ProductionCountryDTO;

import java.util.List;

public class MovieDetailDTO
{
    public int id;
    public String title;
    @JsonProperty("production_companies")
    public List<ProductionCompanyDTO> production_companies;

    @JsonProperty("production_country")
    public List<ProductionCountryDTO> production_countries;
    @JsonProperty("genres")
    public List<GenreDTO> genres;
}
