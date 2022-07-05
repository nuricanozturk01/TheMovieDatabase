package com.company.internshipProject.Entity.JSONParser;

import java.util.ArrayList;

public class Root
{
    public int page;
    public ArrayList<MovieObject> movieObjects;
    public int total_pages;
    public int total_results;


    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public ArrayList<MovieObject> getResults() {
        return movieObjects;
    }

    public void setResults(ArrayList<MovieObject> movieObjects) {
        this.movieObjects = movieObjects;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }
}
