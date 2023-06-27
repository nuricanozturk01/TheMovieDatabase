package nuricanozturk.dev.dtolib.db.moviedto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;

public class MovieWithDetailStringDbDTO
{
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
    public String poster_path;

    public MovieWithDetailStringDbDTO()
    {
    }

    public MovieWithDetailStringDbDTO(long movie_id, String title, String overview, LocalDate release_date,
                                      String language, double popularity, double vote_average,
                                      String poster_path)
    {
        this.movie_id = movie_id;
        this.title = title;
        this.overview = overview;
        this.release_date = release_date;
        this.language = language;
        this.popularity = popularity;
        this.vote_average = vote_average;
        this.poster_path = poster_path;
    }
}
