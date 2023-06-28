package nuricanozturk.dev.tv.data.entity;
/*
 genre_id         int         not null auto_increment primary key,
    genre_name       varchar(45) not null unique,
    tvshow_detail_id int         not null,
 */
public class TvShowGenre
{
    private int genre_id;
    private String genre_name;
    private int tvshow_detail_id;

    public TvShowGenre()
    {
    }

    public TvShowGenre(String genre_name, int tvshow_detail_id)
    {
        this.genre_name = genre_name;
        this.tvshow_detail_id = tvshow_detail_id;
    }

    public int getGenre_id()
    {
        return genre_id;
    }

    public void setGenre_id(int genre_id)
    {
        this.genre_id = genre_id;
    }

    public String getGenre_name()
    {
        return genre_name;
    }

    public void setGenre_name(String genre_name)
    {
        this.genre_name = genre_name;
    }

    public int getTvshow_detail_id()
    {
        return tvshow_detail_id;
    }

    public void setTvshow_detail_id(int tvshow_detail_id)
    {
        this.tvshow_detail_id = tvshow_detail_id;
    }
}
