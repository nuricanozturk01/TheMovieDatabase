package com.company.internshipProject.Exceptions.MovieExceptions;

public class InvalidPageNumberException extends RuntimeException
{
    @Override
    public String getMessage() {
        return "Invalid page Number!!!";
    }
}
