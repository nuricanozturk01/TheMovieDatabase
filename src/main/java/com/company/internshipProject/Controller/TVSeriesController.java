package com.company.internshipProject.Controller;

import com.company.internshipProject.Entity.JSONParser.TV.DetailOfTV;
import com.company.internshipProject.Entity.JSONParser.TV.ResultOfTVSeries;
import com.company.internshipProject.Service.TVSeriesAPIService.ITVSeriesAPIService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/getTvDetail")
    public DetailOfTV getTVDetail(@RequestParam("id") int tv_id)
    {
        return tv.getDetail(tv_id);
    }

    @GetMapping("/getTvSeries")
    public List<ResultOfTVSeries> getTvSeriesPageByPage(@RequestParam(value = "page", defaultValue = "1") int page_number)
    {
        return tv.getTvSeriesPageByPage(page_number);
    }

    @GetMapping("/getPopularTvSeries")
    public List<ResultOfTVSeries> getPopularTvSeriesPageByPage(@RequestParam(value = "page", defaultValue = "1") int page_number)
    {
        return tv.getPopularTvSeriesPageByPage(page_number);
    }

    @GetMapping("/searchTvShow")
    public List<ResultOfTVSeries> searchTvShow (@RequestBody String title)
    {
        JSONObject obj = new JSONObject(title);
        String s = obj.getString("title");
        return tv.searchTvShow(s);
    }
}
