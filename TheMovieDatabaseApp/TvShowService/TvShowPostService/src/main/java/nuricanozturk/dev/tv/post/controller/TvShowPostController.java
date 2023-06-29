package nuricanozturk.dev.tv.post.controller;

import nuricanozturk.dev.tv.data.dto.ExistsDTO;
import nuricanozturk.dev.tv.post.service.TvShowPostService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/tv/post")
public class TvShowPostController
{
    private final TvShowPostService m_tvShowPostService;

    public TvShowPostController(TvShowPostService tvShowPostService)
    {
        m_tvShowPostService = tvShowPostService;
    }

    @PostMapping("save/id")
    public ExistsDTO saveTvShow(@RequestParam("id") long id)
    {
        return m_tvShowPostService.saveTvShowById(id);
    }
}
