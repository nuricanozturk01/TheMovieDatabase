package nuricanozturk.dev.tv.data.dal;

import nuricanozturk.dev.dtolib.db.tvshowdto.DbTvShowWithDetailDTO;
import nuricanozturk.dev.tv.data.entity.TvShow;
import nuricanozturk.dev.tv.data.repository.ITvShowRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class TvShowRepositoryHelper
{
    private final ITvShowRepository m_tvShowRepository;

    public TvShowRepositoryHelper(ITvShowRepository tvShowRepository)
    {
        m_tvShowRepository = tvShowRepository;
    }

    public Iterable<DbTvShowWithDetailDTO> findTvShowWithDetailsById(long id)
    {
        return m_tvShowRepository.findWithDetails(id);
    }

    public void deleteTvShowById(long id)
    {
        m_tvShowRepository.deleteById(id);
    }

    public TvShow saveTvShow(TvShow tvShow)
    {
        return m_tvShowRepository.save(tvShow);
    }

    public Iterable<DbTvShowWithDetailDTO> findAllWithDetails()
    {
        return m_tvShowRepository.findAllWithDetails();
    }

    public boolean existsById(long id)
    {
        return m_tvShowRepository.existById(id);
    }

    public void delete(TvShow tvShow)
    {
        m_tvShowRepository.delete(tvShow);
    }

    public long count()
    {
        return m_tvShowRepository.count();
    }

    public Iterable<DbTvShowWithDetailDTO> findByGenre(long id)
    {
        return m_tvShowRepository.findByGenre(id);
    }

    public Iterable<DbTvShowWithDetailDTO> findByCompany(long id)
    {
        return m_tvShowRepository.findByCompany(id);
    }

    public Iterable<DbTvShowWithDetailDTO> findByCountry(long id)
    {
        return m_tvShowRepository.findByCountry(id);
    }

    public Iterable<DbTvShowWithDetailDTO> findByVoteAverageBetween(double start, double end)
    {
        return m_tvShowRepository.findByVoteAverageBetween(start, end);
    }
}
