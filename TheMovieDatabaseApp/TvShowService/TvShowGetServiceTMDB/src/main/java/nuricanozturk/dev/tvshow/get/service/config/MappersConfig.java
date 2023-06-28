package nuricanozturk.dev.tvshow.get.service.config;

import nuricanozturk.dev.dtolib.mapper.api.*;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MappersConfig
{
    public final IProductionCompanyMapper m_productionCompanyMapper;
    public final IProductionCountryMapper m_productionCountryMapper;
    public final IGenreMapper m_genreMapper;

    public MappersConfig(IProductionCompanyMapper productionCompanyMapper,
                         IProductionCountryMapper productionCountryMapper, IGenreMapper genreMapper)
    {
        m_productionCompanyMapper = productionCompanyMapper;
        m_productionCountryMapper = productionCountryMapper;
        m_genreMapper = genreMapper;
    }
}
