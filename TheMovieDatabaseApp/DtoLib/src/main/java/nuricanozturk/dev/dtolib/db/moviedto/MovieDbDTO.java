package nuricanozturk.dev.dtolib.db.moviedto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class MovieDbDTO
{
    public long movie_id;
    public String language;
    public String title;
    public String overview;
    public double popularity;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    public LocalDate release_date;
    public double vote_average;
}
