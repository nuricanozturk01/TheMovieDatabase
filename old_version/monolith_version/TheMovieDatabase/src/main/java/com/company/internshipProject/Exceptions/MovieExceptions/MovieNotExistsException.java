package com.company.internshipProject.Exceptions.MovieExceptions;

public class MovieNotExistsException extends RuntimeException
{
    @Override
    public String getMessage()
    {
        return "Movie does not exists!!!";
    }
}
