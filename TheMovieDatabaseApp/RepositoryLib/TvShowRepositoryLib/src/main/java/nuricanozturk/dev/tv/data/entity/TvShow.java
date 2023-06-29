package nuricanozturk.dev.tv.data.entity;

/*
tvshow_id      int            not null primary key auto_increment,
    real_tvshow_id int            not null,
    name           varchar(80)    not null,
    language       varchar(45)    not null,
    overview       text           not null,
    popularity     decimal(19, 2) not null,
    vote_average   decimal(19, 2) not null,
    vote_count     int            not null
 */
public class TvShow
{
    private long tv_show_id;
    private long realId;
    private String name;
    private String language;
    private String overview;
    private double popularity;
    private double vote_average;
    private int vote_count;

    public TvShow()
    {
    }

    public TvShow(long realId, String name, String language, String overview, double popularity, double vote_average, int vote_count)
    {
        this.realId = realId;
        this.name = name;
        this.language = language;
        this.overview = overview;
        this.popularity = popularity;
        this.vote_average = vote_average;
        this.vote_count = vote_count;
    }

    public TvShow(long tv_show_id, long real_tv_show_id, String name, String language, String overview, double popularity, double vote_average, int vote_count)
    {
        this.tv_show_id = tv_show_id;
        this.realId = real_tv_show_id;
        this.name = name;
        this.language = language;
        this.overview = overview;
        this.popularity = popularity;
        this.vote_average = vote_average;
        this.vote_count = vote_count;
    }

    public long getTv_show_id()
    {
        return tv_show_id;
    }

    public void setTv_show_id(long tv_show_id)
    {
        this.tv_show_id = tv_show_id;
    }

    public long getRealId()
    {
        return realId;
    }

    public void setRealId(long realId)
    {
        this.realId = realId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getLanguage()
    {
        return language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
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
}
