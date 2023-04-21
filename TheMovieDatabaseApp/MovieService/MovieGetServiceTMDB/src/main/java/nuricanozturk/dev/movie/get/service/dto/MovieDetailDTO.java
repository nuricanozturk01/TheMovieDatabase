package nuricanozturk.dev.movie.get.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

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
