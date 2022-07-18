package com.company.internshipProject.DAO.TVSeriesAPIDAO;

import com.company.internshipProject.Entity.JSONParser.TV.DetailOfTV;
import com.company.internshipProject.Entity.JSONParser.TV.ResultOfTVSeries;

import java.util.List;

public interface ITVSeriesAPIDAO
{
    DetailOfTV getDetail(int tv_id);

    List<ResultOfTVSeries> getTvSeriesPageByPage(int page_number);
    List<ResultOfTVSeries> getPopularTvSeriesPageByPage(int page_number);
    List<ResultOfTVSeries> searchTvShow(String title);


}
