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

    public TvShowWithDetailDTO()
    {
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getOriginal_language()
    {
        return original_language;
    }

    public void setOriginal_language(String original_language)
    {
        this.original_language = original_language;
    }

    public String getOverview()
    {
        return overview;
    }

    public void setOverview(String overview)
    {
        this.overview = overview;
    }

    public double getPopularity()
    {
        return popularity;
    }

    public void setPopularity(double popularity)
    {
        this.popularity = popularity;
    }

    public String getPoster_path()
    {
        return poster_path;
    }

    public void setPoster_path(String poster_path)
    {
        this.poster_path = poster_path;
    }

    public double getVote_average()
    {
        return vote_average;
    }

    public void setVote_average(double vote_average)
    {
        this.vote_average = vote_average;
    }

    public int getVote_count()
    {
        return vote_count;
    }

    public void setVote_count(int vote_count)
    {
        this.vote_count = vote_count;
    }

    public int getNumber_of_episodes()
    {
        return number_of_episodes;
    }

    public void setNumber_of_episodes(int number_of_episodes)
    {
        this.number_of_episodes = number_of_episodes;
    }

    public int getNumber_of_seasons()
    {
        return number_of_seasons;
    }

    public void setNumber_of_seasons(int number_of_seasons)
    {
        this.number_of_seasons = number_of_seasons;
    }

    public ArrayList<ProductionCompany> getProduction_companies()
    {
        return production_companies;
    }

    public void setProduction_companies(ArrayList<ProductionCompany> production_companies)
    {
        this.production_companies = production_companies;
    }

    public ArrayList<ProductionCountry> getProduction_countries()
    {
        return production_countries;
    }

    public void setProduction_countries(ArrayList<ProductionCountry> production_countries)
    {
        this.production_countries = production_countries;
    }

    public ArrayList<Genre> getGenres()
    {
        return genres;
    }

    public void setGenres(ArrayList<Genre> genres)
    {
        this.genres = genres;
    }

    public ArrayList<String> getLanguages()
    {
        return languages;
    }

    public void setLanguages(ArrayList<String> languages)
    {
        this.languages = languages;
    }
}
