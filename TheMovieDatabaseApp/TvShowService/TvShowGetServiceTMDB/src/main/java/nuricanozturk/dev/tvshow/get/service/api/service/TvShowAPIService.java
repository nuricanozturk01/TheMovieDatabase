package nuricanozturk.dev.tvshow.get.service.api.service;

import nuricanozturk.dev.dtolib.api.tvshowdto.TvShowDetailWrapperDTO;
import nuricanozturk.dev.dtolib.api.tvshowdto.TvShowWithDetailDTO;
import nuricanozturk.dev.dtolib.api.tvshowdto.TvShowsDTO;
import nuricanozturk.dev.dtolib.entity.api.tv.Root;
import nuricanozturk.dev.dtolib.entity.api.tv.TvShowDetailRoot;
import nuricanozturk.dev.dtolib.mapper.api.ITvShowDetailMapper;
import nuricanozturk.dev.dtolib.mapper.api.ITvShowMapper;
import nuricanozturk.dev.dtolib.mapper.api.ITvShowWithDetailMapper;
import nuricanozturk.dev.tvshow.get.service.config.ValueConfig;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

import static java.lang.String.format;

@Service
@Scope("prototype")
public class TvShowAPIService
{

    private final RestTemplate m_restTemplate;
    private final ValueConfig m_valueConfig;
    private final ITvShowMapper m_tvShowMapper;
    private final ITvShowDetailMapper m_tvShowDetailMapper;
    private final ITvShowWithDetailMapper m_tvShowWithDetailMapper;

    public TvShowAPIService(RestTemplate restTemplate, ValueConfig valueConfig, ITvShowMapper tvShowMapper, ITvShowDetailMapper tvShowDetailMapper, ITvShowWithDetailMapper tvShowWithDetailMapper)
    {
        m_restTemplate = restTemplate;
        m_valueConfig = valueConfig;
        m_tvShowMapper = tvShowMapper;
        m_tvShowDetailMapper = tvShowDetailMapper;
        m_tvShowWithDetailMapper = tvShowWithDetailMapper;
    }

    private <T> T getObject(String url, Object query, Class<?> cls)
    {
        return Objects.requireNonNull(m_restTemplate.<T>getForObject(format(url, query), (Class<T>) cls));
    }

    public TvShowsDTO getAllByPage(int page)
    {
        return m_tvShowMapper.toTvShowsDTO(m_tvShowMapper.toTvShowDTO(((Root) getObject(m_valueConfig.tvShowSearchUrl, page, Root.class)).results));
    }

    public TvShowDetailWrapperDTO getDetailsById(int Id)
    {
        return m_tvShowDetailMapper.toTvShowDetailWrapperDTO(m_tvShowDetailMapper.toTvShowDetailDTO((TvShowDetailRoot) getObject(m_valueConfig.tvShowDetailUrl, Id, TvShowDetailRoot.class)));
    }

    public TvShowWithDetailDTO getTvSeriesWithDetailsById(int id)
    {
        return m_tvShowWithDetailMapper.toTvShowWithDetailDTO(getObject(m_valueConfig.tvShowDetailUrl, id, TvShowDetailRoot.class));
    }

    public TvShowsDTO getPopularTvSeriesByPage(int page)
    {
        return m_tvShowMapper.toTvShowsDTO(m_tvShowMapper.toTvShowDTO(((Root) getObject(m_valueConfig.tvShowSearchUrl, page, Root.class)).results));
    }


    public TvShowsDTO searchTvShowByQuery(String query)
    {
        return m_tvShowMapper.toTvShowsDTO(m_tvShowMapper.toTvShowDTO(((Root) getObject(m_valueConfig.tvShowSearchUrl, query, Root.class)).results));
    }
}
