package com.company.internshipProject.Service.TVSeriesAPIService;

import com.company.internshipProject.DAO.TVSeriesAPIDAO.ITVSeriesAPIDAO;
import com.company.internshipProject.Entity.JSONParser.TV.DetailOfTV;
import com.company.internshipProject.Entity.JSONParser.TV.ResultOfTVSeries;
import com.company.internshipProject.Entity.TVSeriesEntity.TVShow;
import com.company.internshipProject.Entity.UserEntity;
import com.company.internshipProject.Exceptions.MovieExceptions.InvalidPageNumberException;
import com.company.internshipProject.Exceptions.TVSeriesExceptions.InvalidTvSeriesIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public DetailOfTV getDetail(int tv_id)
    {
        if (tv_id < 0 || tv_id > Integer.MAX_VALUE)
            throw new InvalidTvSeriesIdException();

        return tvDao.getDetail(tv_id);
    }

    @Override
    public List<ResultOfTVSeries> getTvSeriesPageByPage(int page_number)
    {
        if (page_number < 0 || page_number > Integer.MAX_VALUE)
            throw new InvalidPageNumberException();

        return tvDao.getTvSeriesPageByPage(page_number);
    }

    @Override
    public List<ResultOfTVSeries> getPopularTvSeriesPageByPage(int page_number)
    {
        if (page_number < 0 || page_number > Integer.MAX_VALUE)
            throw new InvalidPageNumberException();

        return tvDao.getPopularTvSeriesPageByPage(page_number);
    }

    @Override
    public List<ResultOfTVSeries> searchTvShow(String title)
    {
        return tvDao.searchTvShow(title);
    }
    public void addTvShow(UserEntity user, TVShow tvShow)
    {
        if (user.getTvShows() == null)
            user.setTvShows(new ArrayList<>());

        user.getTvShows().add(tvShow);
    }
}
