package nuricanozturk.dev.movie.get.dto;

import jakarta.persistence.Column;

import java.time.LocalDate;

public class MovieDTO
{
    public long movie_id;
    public String language;
    public String title;
    public String overview;
    public double popularity;
    public LocalDate release_date;
    public double vote_average;
}
