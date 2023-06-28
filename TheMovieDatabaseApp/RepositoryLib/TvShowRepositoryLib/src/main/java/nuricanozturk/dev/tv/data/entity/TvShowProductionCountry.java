package nuricanozturk.dev.tv.data.entity;
/*
company_id       int         not null auto_increment primary key,
    company_name     varchar(45) not null unique,
    tvshow_detail_id int         not null,
 */
public class TvShowProductionCountry
{
    private int country_id;
    private String country_name;
    private int tvshow_detail_id;

    public TvShowProductionCountry()
    {
    }

    public TvShowProductionCountry(String company_name, int tvshow_detail_id)
    {
        this.country_name = company_name;
        this.tvshow_detail_id = tvshow_detail_id;
    }

    public int getCountry_id()
    {
        return country_id;
    }

    public void setCountry_id(int country_id)
    {
        this.country_id = country_id;
    }

    public String getCountry_name()
    {
        return country_name;
    }

    public void setCountry_name(String country_name)
    {
        this.country_name = country_name;
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
