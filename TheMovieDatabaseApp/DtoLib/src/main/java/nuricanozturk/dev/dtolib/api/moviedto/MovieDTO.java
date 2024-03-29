package nuricanozturk.dev.dtolib.api.moviedto;


import com.fasterxml.jackson.annotation.JsonIgnore;

public class MovieDTO
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
}
