package nuricanozturk.dev.dtolib.db.moviedto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;

public class MovieWithDetailStringDbDTO
{
    @JsonIgnore
    public long movie_id;
    @JsonIgnore
    public long movie_detail_id;
    @JsonIgnore
    public long real_movie_id;
    public String title;
    public String overview;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    public LocalDate release_date;
    public String language;
    public double popularity;
    public double vote_average;
    public String genres;
    public String production_companies;
    public String production_countries;




}
