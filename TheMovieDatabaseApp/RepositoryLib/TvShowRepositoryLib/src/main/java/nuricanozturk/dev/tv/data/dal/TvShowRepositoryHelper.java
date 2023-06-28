package nuricanozturk.dev.tv.data.dal;

import nuricanozturk.dev.dtolib.db.tvshowdto.DbTvShowWithDetailsDTO;
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

    public Iterable<DbTvShowWithDetailsDTO> findTvShowWithDetailsById(long id)
    {
        return m_tvShowRepository.findAllWithDetails(id);
    }
}
