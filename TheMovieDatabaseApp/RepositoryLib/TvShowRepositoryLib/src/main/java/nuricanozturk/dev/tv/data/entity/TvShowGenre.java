package nuricanozturk.dev.tv.data.entity;
/*
 genre_id         int         not null auto_increment primary key,
    genre_name       varchar(45) not null unique,
    tvshow_detail_id int         not null,
 */
public class TvShowGenre
{
    private int genre_id;
    private int genre_db_id;
    private int tvshow_detail_id;

    public TvShowGenre()
    {
    }


    public int getGenre_db_id()
    {
        return genre_db_id;
    }

    public void setGenre_db_id(int genre_db_id)
    {
        this.genre_db_id = genre_db_id;
    }

    public int getGenre_id()
    {
        return genre_id;
    }

    public void setGenre_id(int genre_id)
    {
        this.genre_id = genre_id;
    }

    public TvShowGenre(int genre_db_id, int tvshow_detail_id)
    {
        this.genre_db_id = genre_db_id;
        this.tvshow_detail_id = tvshow_detail_id;
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
