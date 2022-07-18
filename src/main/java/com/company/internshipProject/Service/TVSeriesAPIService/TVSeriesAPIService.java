package com.company.internshipProject.Service.TVSeriesAPIService;

import com.company.internshipProject.DAO.TVSeriesAPIDAO.ITVSeriesAPIDAO;
import com.company.internshipProject.Entity.JSONParser.TV.DetailOfTV;
import com.company.internshipProject.Entity.JSONParser.TV.ResultOfTVSeries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TVSeriesAPIService implements ITVSeriesAPIService
{
    private ITVSeriesAPIDAO tvDao;

    @Autowired
    public TVSeriesAPIService(ITVSeriesAPIDAO tvDao)
    {
        this.tvDao = tvDao;
    }


    @Override
    public DetailOfTV getDetail(int tv_id) {
        return tvDao.getDetail(tv_id);
    }

    @Override
    public List<ResultOfTVSeries> getTvSeriesPageByPage(int page_number) {
        return tvDao.getTvSeriesPageByPage(page_number);
    }

    @Override
    public List<ResultOfTVSeries> getPopularTvSeriesPageByPage(int page_number) {
        return tvDao.getPopularTvSeriesPageByPage(page_number);
    }

    @Override
    public List<ResultOfTVSeries> searchTvShow(String title) {
        return tvDao.searchTvShow(title);
    }
}
