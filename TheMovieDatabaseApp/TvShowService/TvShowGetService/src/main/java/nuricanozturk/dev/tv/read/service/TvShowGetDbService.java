package nuricanozturk.dev.tv.read.service;

import nuricanozturk.dev.dtolib.db.tvshowdto.DbTvShowWithDetailsDTO;
import nuricanozturk.dev.tv.data.dal.TvShowRepositoryHelper;
import org.springframework.stereotype.Service;

@Service
public class TvShowGetDbService
{
    private final TvShowRepositoryHelper m_repositoryHelper;

    public TvShowGetDbService(TvShowRepositoryHelper repositoryHelper)
    {
        m_repositoryHelper = repositoryHelper;
    }

    public Iterable<DbTvShowWithDetailsDTO> findTvShowWithDetailsById(long id)
    {
        return m_repositoryHelper.findTvShowWithDetailsById(id);
    }
}
