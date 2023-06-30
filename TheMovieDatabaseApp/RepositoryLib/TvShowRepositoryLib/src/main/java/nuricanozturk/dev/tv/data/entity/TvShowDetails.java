package nuricanozturk.dev.tv.data.entity;

/*

tvshow_detail_id int not null primary key auto_increment,
    episodes_count   int not null,
    season_count     int not null,
    poster_path      varchar(121),
    tvshow_id        int not null,
 */
public class TvShowDetails
{
    private int tvshow_id;
    private int tv_show_detail_id;
    private int episodes_count;
    private int season_count;
    private String poster_path;

    public TvShowDetails()
    {
    }

    public TvShowDetails(int tvshow_id, int episodes_count, int season_count, String poster_path)
    {
        this.tvshow_id = tvshow_id;
        this.episodes_count = episodes_count;
        this.season_count = season_count;
        this.poster_path = poster_path;
    }

    public int getTvshow_id() {
        return tvshow_id;
    }

    public void setTvshow_id(int tvshow_id) {
        this.tvshow_id = tvshow_id;
    }

    public int getTv_show_detail_id()
    {
        return tv_show_detail_id;
    }

    public void setTv_show_detail_id(int tv_show_detail_id)
    {
        this.tv_show_detail_id = tv_show_detail_id;
    }

    public int getEpisodes_count()
    {
        return episodes_count;
    }

    public void setEpisodes_count(int episodes_count)
    {
        this.episodes_count = episodes_count;
    }

    public int getSeason_count()
    {
        return season_count;
    }

    public void setSeason_count(int season_count)
    {
        this.season_count = season_count;
    }

    public String getPoster_path()
    {
        return poster_path;
    }

    public void setPoster_path(String poster_path)
    {
        this.poster_path = poster_path;
    }
}
