package nuricanozturk.dev.dtolib.db.tvshowdto;

public class DbTvShowWithDetailsDTO
{
    public long tvShowId;
    public String name;
    public String language;
    public String overview;
    public String posterPath;
    public String genres;
    public String companies;
    public String countries;
    public double popularity;
    public double voteAverage;
    public int voteCount;
    public int episodesCount;
    public int seasonCount;

    public DbTvShowWithDetailsDTO(long tvShowId, String name, String language, String overview, String posterPath, String genres, String companies, String countries, double popularity, double voteAverage, int voteCount, int episodesCount, int seasonCount)
    {
        this.tvShowId = tvShowId;
        this.name = name;
        this.language = language;
        this.overview = overview;
        this.posterPath = posterPath;
        this.genres = genres;
        this.companies = companies;
        this.countries = countries;
        this.popularity = popularity;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
        this.episodesCount = episodesCount;
        this.seasonCount = seasonCount;
    }
}
