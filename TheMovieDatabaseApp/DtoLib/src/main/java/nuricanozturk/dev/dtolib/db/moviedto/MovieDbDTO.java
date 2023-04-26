package nuricanozturk.dev.dtolib.db.moviedto;

import java.time.LocalDate;

public class MovieDbDTO
{
    public long movie_id;
    public String language;
    public String title;
    public String overview;
    public double popularity;
    public LocalDate release_date;
    public double vote_average;
}
