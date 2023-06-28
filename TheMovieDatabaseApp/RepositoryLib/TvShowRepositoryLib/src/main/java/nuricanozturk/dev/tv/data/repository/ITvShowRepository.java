package nuricanozturk.dev.tv.data.repository;

import nuricanozturk.dev.dtolib.db.tvshowdto.DbTvShowWithDetailsDTO;
import nuricanozturk.dev.tv.data.entity.TvShow;

public interface ITvShowRepository extends ICrudRepository<TvShow, Long>
{
    Iterable<DbTvShowWithDetailsDTO> findWithDetails(long id);
    Iterable<DbTvShowWithDetailsDTO> findAllWithDetails();
    Iterable<DbTvShowWithDetailsDTO> findByGenre(String name);
    Iterable<DbTvShowWithDetailsDTO> findByCompany(String name);
    Iterable<DbTvShowWithDetailsDTO> findByCountry(String name);
    Iterable<DbTvShowWithDetailsDTO> findByVoteAverageBetween(double start, double end);
}
