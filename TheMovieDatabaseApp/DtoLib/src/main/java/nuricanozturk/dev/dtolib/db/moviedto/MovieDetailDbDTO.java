package nuricanozturk.dev.dtolib.db.moviedto;


import com.fasterxml.jackson.annotation.JsonIgnore;

public class MovieDetailDbDTO
{
    @JsonIgnore
    public long movie_detail_id;
    @JsonIgnore
    public long movie_db_id;
    @JsonIgnore
    public long real_movie_id;
    public String title;
    public String genres;
    public String production_companies;
    public String production_countries;
    public String poster_path;


    public  MovieDetailDbDTO(long movie_detail_id, long real_movie_id, String title, String genres, String production_companies, String production_countries,String poster_path)
    {
        this.movie_detail_id = movie_detail_id;
        this.real_movie_id = real_movie_id;
        this.title = title;
        this.genres = genres;
        this.production_companies = production_companies;
        this.production_countries = production_countries;
        this.poster_path = poster_path;
        movie_db_id = movie_detail_id;
    }
}
