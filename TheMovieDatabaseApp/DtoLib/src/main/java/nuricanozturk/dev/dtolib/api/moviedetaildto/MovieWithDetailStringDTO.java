package nuricanozturk.dev.dtolib.api.moviedetaildto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieWithDetailStringDTO
{
    public int id;
    public String original_language;
    public String original_title;
    public String overview;
    public double popularity;
    @JsonIgnore
    public String poster_path;
    public String release_date;
    public String title;
    public double vote_average;
    public int vote_count;
    @JsonProperty("production_companies")
    public String production_companies;
    @JsonProperty("production_country")
    public String production_countries;
    @JsonProperty("genres")
    public String genres;
}
