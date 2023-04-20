package nuricanozturk.dev.movie.get.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MovieDetailStringDTO
{
    public int id;
    public String title;
    @JsonProperty("production_companies")
    public String production_companies;

    @JsonProperty("production_country")
    public String production_countries;
    @JsonProperty("genres")
    public String genres;
}
