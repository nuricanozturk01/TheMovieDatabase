package nuricanozturk.dev.tvshow.get.service.controller;

import nuricanozturk.dev.dtolib.api.tvshowdto.TvShowDetailWrapperDTO;
import nuricanozturk.dev.dtolib.api.tvshowdto.TvShowWithDetailDTO;
import nuricanozturk.dev.dtolib.api.tvshowdto.TvShowsDTO;
import nuricanozturk.dev.tvshow.get.service.api.service.TvShowAPIService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/tmdb/tv")
public class TvShowAPIController
{
    private final TvShowAPIService m_tvShowAPIService;

    public TvShowAPIController(TvShowAPIService mTvShowAPIService)
    {
        m_tvShowAPIService = mTvShowAPIService;
    }

    @GetMapping("all/page")
    public TvShowsDTO getAllByPage(@RequestParam("p") int page)
    {
        return m_tvShowAPIService.getAllByPage(page);
    }

    @GetMapping("find/detail/id")
    public TvShowDetailWrapperDTO getDetailsById(@RequestParam("id") int id)
    {
        return m_tvShowAPIService.getDetailsById(id);
    }

    @GetMapping("find/tv_with_detail/id")
    public TvShowWithDetailDTO getTvSeriesWithDetailsById(@RequestParam("id") int id)
    {
        return m_tvShowAPIService.getTvSeriesWithDetailsById(id);
    }

    @GetMapping("find/popular/page")
    public TvShowsDTO getPopularTvSeriesByPage(@RequestParam("p") int page)
    {
        return m_tvShowAPIService.getPopularTvSeriesByPage(page);
    }

    @GetMapping("search/query")
    public TvShowsDTO searchTvShowByQuery(@RequestParam("q") String query)
    {
        return m_tvShowAPIService.searchTvShowByQuery(query);
    }
}
