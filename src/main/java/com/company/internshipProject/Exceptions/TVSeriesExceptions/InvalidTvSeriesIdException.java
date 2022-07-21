package com.company.internshipProject.Exceptions.TVSeriesExceptions;

public class InvalidTvSeriesIdException extends RuntimeException
{
    @Override
    public String getMessage() {
        return "Invalid id for TV Series!";
    }
}
