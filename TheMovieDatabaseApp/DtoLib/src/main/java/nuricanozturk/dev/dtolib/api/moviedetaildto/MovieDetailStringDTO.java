package nuricanozturk.dev.dtolib.api.moviedetaildto;

import com.fasterxml.jackson.annotation.JsonProperty;

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
    public String poster_path;
}
