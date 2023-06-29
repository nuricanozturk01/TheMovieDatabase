package nuricanozturk.dev.tv.data.repository;

import nuricanozturk.dev.dtolib.db.tvshowdto.DbTvShowWithDetailDTO;
import nuricanozturk.dev.tv.data.entity.TvShow;

public interface ITvShowRepository extends ICrudRepository<TvShow, Long>
{
    Iterable<DbTvShowWithDetailDTO> findWithDetails(long id);
    Iterable<DbTvShowWithDetailDTO> findAllWithDetails();
    Iterable<DbTvShowWithDetailDTO> findByGenre(long id);
    Iterable<DbTvShowWithDetailDTO> findByCompany(long id);
    Iterable<DbTvShowWithDetailDTO> findByCountry(long id);
    Iterable<DbTvShowWithDetailDTO> findByVoteAverageBetween(double start, double end);
}
