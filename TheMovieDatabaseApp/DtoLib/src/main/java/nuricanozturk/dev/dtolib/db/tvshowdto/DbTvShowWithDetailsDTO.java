package nuricanozturk.dev.dtolib.db.tvshowdto;

import java.util.List;

public class DbTvShowWithDetailsDTO
{
    public List<DbTvShowWithDetailDTO> tv_shows;

    public DbTvShowWithDetailsDTO(List<DbTvShowWithDetailDTO> tv_shows)
    {
        this.tv_shows = tv_shows;
    }
}
