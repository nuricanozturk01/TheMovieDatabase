package nuricanozturk.dev.movie.get.service.config;

import nuricanozturk.dev.dtolib.mapper.api.*;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MappersConfig
{
    public final IMovieMapper m_movieMapper;
    public final IMovieDetailMapper m_movieDetailMapper;
    public final IProductionCompanyMapper m_productionCompanyMapper;
    public final IProductionCountryMapper m_productionCountryMapper;
    public final IGenreMapper m_genreMapper;

    public MappersConfig(IMovieMapper movieMapper, IMovieDetailMapper movieDetailMapper,
                         IProductionCompanyMapper productionCompanyMapper,
                         IProductionCountryMapper productionCountryMapper, IGenreMapper genreMapper)
    {
        m_movieMapper = movieMapper;
        m_movieDetailMapper = movieDetailMapper;
        m_productionCompanyMapper = productionCompanyMapper;
        m_productionCountryMapper = productionCountryMapper;
        m_genreMapper = genreMapper;
    }
}
