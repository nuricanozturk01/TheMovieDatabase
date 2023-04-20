package com.company.internshipProject.Service.TVSeriesAPIService;

import com.company.internshipProject.Entity.JSONParser.TV.DetailOfTV;
import com.company.internshipProject.Entity.JSONParser.TV.ResultOfTVSeries;
import com.company.internshipProject.Entity.TVSeriesEntity.TVShow;
import com.company.internshipProject.Entity.UserEntity;

import java.util.List;

public interface ITVSeriesAPIService
{
    DetailOfTV getDetail(int tv_id);

    List<ResultOfTVSeries> getTvSeriesPageByPage(int page_number);
    List<ResultOfTVSeries> getPopularTvSeriesPageByPage(int page_number);
    List<ResultOfTVSeries> searchTvShow(String title);
    void addTvShow(UserEntity user, TVShow tvShow);
}
