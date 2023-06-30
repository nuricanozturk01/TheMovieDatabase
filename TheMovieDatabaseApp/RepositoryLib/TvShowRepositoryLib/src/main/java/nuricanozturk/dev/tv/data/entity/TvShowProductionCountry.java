package nuricanozturk.dev.tv.data.entity;

public class TvShowProductionCountry
{
    private int country_id;
    private int country_db_id;

    private int tvshow_detail_id;

    public TvShowProductionCountry()
    {
    }

    public TvShowProductionCountry(int country_db_id, int tvshow_detail_id)
    {
        this.country_db_id = country_db_id;
        this.tvshow_detail_id = tvshow_detail_id;
    }

    public int getCountry_db_id()
    {
        return country_db_id;
    }

    public void setCountry_db_id(int country_db_id)
    {
        this.country_db_id = country_db_id;
    }

    public int getCountry_id()
    {
        return country_id;
    }

    public void setCountry_id(int country_id)
    {
        this.country_id = country_id;
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
