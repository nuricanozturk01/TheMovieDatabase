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

    public Iterable<DbTvShowWithDetailsDTO> findByCompany(String companyName)
    {
        return m_repositoryHelper.findByCompany(companyName);
    }

    public Iterable<DbTvShowWithDetailsDTO> findByCountry(String countryName)
    {
        return m_repositoryHelper.findByCountry(countryName);
    }

    public Iterable<DbTvShowWithDetailsDTO> findByGenre(String genreName)
    {
        return m_repositoryHelper.findByGenre(genreName);
    }

    public Iterable<DbTvShowWithDetailsDTO> findByVoteAverageBetween(double start, double end)
    {
        return m_repositoryHelper.findByVoteAverageBetween(start, end);
    }

    public Iterable<DbTvShowWithDetailsDTO> findAllWithDetails()
    {
        return m_repositoryHelper.findAllWithDetails();
    }

    // error on list size == 0
    public boolean existsById(long id)
    {
        return m_repositoryHelper.existsById(id);
    }

    public long count()
    {
        return m_repositoryHelper.count();
    }
}
