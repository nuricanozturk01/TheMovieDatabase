package nuricanozturk.dev.movie.get.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MovieDetailStringDTO
{
    public String title;
    public double vote_average;
    public int vote_count;
    @JsonProperty("production_companies")
    public String production_companies;

    @JsonProperty("production_country")
    public String production_countries;
    public String release_date;
    public String original_language;
    public String original_title;
    @JsonProperty("genres")
    public String genres;
}
