package nuricanozturk.dev.dtolib.api.tvshowdto;

import nuricanozturk.dev.dtolib.entity.api.movie.Genre;
import nuricanozturk.dev.dtolib.entity.api.movie.ProductionCompany;
import nuricanozturk.dev.dtolib.entity.api.movie.ProductionCountry;

import java.util.ArrayList;

public class TvShowWithDetailDTO
{
    public int id;
    public String name;
    public String original_language;
    public String overview;
    public double popularity;
    public String poster_path;
    public double vote_average;
    public int vote_count;
    public int number_of_episodes;
    public int number_of_seasons;
    public ArrayList<ProductionCompany> production_companies;
    public ArrayList<ProductionCountry> production_countries;
    public ArrayList<Genre> genres;
    public ArrayList<String> languages;
}
