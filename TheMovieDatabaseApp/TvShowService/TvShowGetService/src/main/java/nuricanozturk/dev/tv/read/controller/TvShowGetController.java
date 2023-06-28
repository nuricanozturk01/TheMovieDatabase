package nuricanozturk.dev.tv.read.controller;

import nuricanozturk.dev.dtolib.db.tvshowdto.DbTvShowWithDetailsDTO;
import nuricanozturk.dev.tv.read.service.TvShowGetDbService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/tv")
public class TvShowGetController
{

    private final TvShowGetDbService m_service;

    public TvShowGetController(TvShowGetDbService service)
    {
        m_service = service;
    }

    @GetMapping("find/id")
    public Iterable<DbTvShowWithDetailsDTO> findTvShowWithDetailsById(@RequestParam("id") long id)
    {
        return m_service.findTvShowWithDetailsById(id);
    }
}
