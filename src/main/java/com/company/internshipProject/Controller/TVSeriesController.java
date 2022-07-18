package com.company.internshipProject.Controller;

import com.company.internshipProject.Entity.JSONParser.TV.DetailOfTV;
import com.company.internshipProject.Entity.JSONParser.TV.ResultOfTVSeries;
import com.company.internshipProject.Service.TVSeriesAPIService.ITVSeriesAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tv")
public class TVSeriesController
{
    private ITVSeriesAPIService tv;

    @Autowired
    public TVSeriesController(ITVSeriesAPIService tv) {
        this.tv = tv;
    }

    @GetMapping("/getTvDetail/{tv_id}")
    public DetailOfTV getTVDetail(@PathVariable int tv_id)
    {
        return tv.getDetail(tv_id);
    }

    @GetMapping("/getTvSeries/{page_number}")
    public List<ResultOfTVSeries> getTvSeriesPageByPage(@PathVariable int page_number)
    {
        return tv.getTvSeriesPageByPage(page_number);
    }

    @GetMapping("/getPopularTvSeries/{page_number}")
    public List<ResultOfTVSeries> getPopularTvSeriesPageByPage(@PathVariable int page_number)
    {
        return tv.getPopularTvSeriesPageByPage(page_number);
    }

    @GetMapping("/searchTvShow/{title}")
    public List<ResultOfTVSeries> searchTvShow (@PathVariable String title)
    {
        return tv.searchTvShow(title);
    }
}
