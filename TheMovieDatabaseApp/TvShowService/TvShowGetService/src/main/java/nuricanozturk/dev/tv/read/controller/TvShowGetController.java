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
    public DbTvShowWithDetailsDTO findTvShowWithDetailsById(@RequestParam("id") long id)
    {
        return m_service.findTvShowWithDetailsById(id);
    }
    @GetMapping("find/company/name")
    public DbTvShowWithDetailsDTO findByCompany(@RequestParam("n") String companyName)
    {
        return m_service.findByCompany(companyName);
    }

    @GetMapping("find/country/name")
    public DbTvShowWithDetailsDTO findByCountry(@RequestParam("n") String countryName)
    {
        return m_service.findByCountry(countryName);
    }

    @GetMapping("find/genre/name")
    public DbTvShowWithDetailsDTO findByGenre(@RequestParam("n") String genreName)
    {
        return m_service.findByGenre(genreName);
    }

    @GetMapping("find/vote/between")
    public DbTvShowWithDetailsDTO findByVoteAverageBetween(@RequestParam("b") double start, @RequestParam("e") double end)
    {
        return m_service.findByVoteAverageBetween(start, end);
    }

    @GetMapping("find/all")
    public DbTvShowWithDetailsDTO findAllWithDetails()
    {
        return m_service.findAllWithDetails();
    }

    @GetMapping("exists/id")
    public boolean existsById(@RequestParam("id") long id)
    {
        return m_service.existsById(id);
    }

    @GetMapping("count")
    public long count()
    {
        return m_service.count();
    }
}
