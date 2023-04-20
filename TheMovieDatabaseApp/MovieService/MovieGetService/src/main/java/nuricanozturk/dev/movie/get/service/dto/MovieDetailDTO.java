package nuricanozturk.dev.movie.get.service.dto;

import nuricanozturk.dev.movie.get.service.api.entity.Genre;
import nuricanozturk.dev.movie.get.service.api.entity.ProductionCompany;
import nuricanozturk.dev.movie.get.service.api.entity.ProductionCountry;

import java.util.ArrayList;

public class MovieDetailDTO
{
    public String title;
    public double vote_average;
    public int vote_count;
    public ArrayList<ProductionCompany> production_companies;
    public ArrayList<ProductionCountry> production_countries;
    public String release_date;
    public String original_language;
    public String original_title;
    public ArrayList<Genre> genres;
}
