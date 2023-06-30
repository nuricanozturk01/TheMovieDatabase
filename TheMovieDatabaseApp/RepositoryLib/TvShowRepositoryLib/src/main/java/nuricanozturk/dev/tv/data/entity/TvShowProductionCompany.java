package nuricanozturk.dev.tv.data.entity;
/*
company_id       int         not null auto_increment primary key,
    company_name     varchar(45) not null unique,
    tvshow_detail_id int         not null,
 */
public class TvShowProductionCompany
{
    private int company_id;
    private int company_db_id;

    private int tvshow_detail_id;

    public TvShowProductionCompany()
    {
    }

    public TvShowProductionCompany(int company_db_id, int tvshow_detail_id)
    {
        this.company_db_id = company_db_id;
        this.tvshow_detail_id = tvshow_detail_id;
    }

    public int getCompany_id()
    {
        return company_id;
    }

    public void setCompany_id(int company_id)
    {
        this.company_id = company_id;
    }

    public int getCompany_db_id()
    {
        return company_db_id;
    }

    public void setCompany_db_id(int company_db_id)
    {
        this.company_db_id = company_db_id;
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
