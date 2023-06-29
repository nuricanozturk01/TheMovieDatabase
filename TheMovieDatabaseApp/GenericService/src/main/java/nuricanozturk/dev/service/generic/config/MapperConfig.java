package nuricanozturk.dev.service.generic.config;

import nuricanozturk.dev.service.generic.mapper.*;
import org.springframework.stereotype.Component;

@Component
public class MapperConfig
{
    public final IGenreDbMapper m_genreDbMapper;
    public final ICompanyDbMapper m_companyDbMapper;
    public final ICountryDbMapper m_countryDbMapper;

    public final IDbGenreMapper m_dbGenreMapper;
    public final IDbCompanyMapper m_dbCompanyMapper;
    public final IDbCountryMapper m_dbCountryMapper;

    public MapperConfig(IGenreDbMapper genreDbMapper, ICompanyDbMapper companyDbMapper, ICountryDbMapper countryDbMapper,
                        IDbGenreMapper dbGenreMapper, IDbCompanyMapper dbCompanyMapper, IDbCountryMapper dbCountryMapper)
    {
        m_genreDbMapper = genreDbMapper;
        m_companyDbMapper = companyDbMapper;
        m_countryDbMapper = countryDbMapper;
        m_dbGenreMapper = dbGenreMapper;
        m_dbCompanyMapper = dbCompanyMapper;
        m_dbCountryMapper = dbCountryMapper;
    }
}
