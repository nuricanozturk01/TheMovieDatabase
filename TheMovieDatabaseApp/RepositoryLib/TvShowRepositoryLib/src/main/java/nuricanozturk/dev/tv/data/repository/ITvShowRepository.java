package nuricanozturk.dev.tv.data.repository;

import nuricanozturk.dev.dtolib.db.tvshowdto.DbTvShowWithDetailsDTO;
import nuricanozturk.dev.tv.data.entity.TvShow;

public interface ITvShowRepository extends ICrudRepository<TvShow, Long>
{
    Iterable<DbTvShowWithDetailsDTO> findAllWithDetails(long id);
}
