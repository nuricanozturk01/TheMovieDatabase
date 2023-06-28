package nuricanozturk.dev.dtolib.api.tvshowdto;

import nuricanozturk.dev.dtolib.entity.api.movie.Genre;
import nuricanozturk.dev.dtolib.entity.api.movie.ProductionCompany;
import nuricanozturk.dev.dtolib.entity.api.movie.ProductionCountry;

import java.util.ArrayList;

public class TvShowDetailDTO {

    public String name;
    public int number_of_episodes;
    public int number_of_seasons;
    public ArrayList<ProductionCompany> production_companies;
    public ArrayList<ProductionCountry> production_countries;
    public ArrayList<Genre> genres;
    public ArrayList<String> languages;
}
