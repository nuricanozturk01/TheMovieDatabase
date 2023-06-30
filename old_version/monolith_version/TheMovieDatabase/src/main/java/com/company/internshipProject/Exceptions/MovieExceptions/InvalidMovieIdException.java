package com.company.internshipProject.Exceptions.MovieExceptions;

public class InvalidMovieIdException extends RuntimeException
{
    @Override
    public String getMessage() {
        return "Invalid movie id!!!";
    }
}
