package com.company.internshipProject.Exceptions.MovieExceptions;

public class PermissionDeniedException extends RuntimeException
{
    @Override
    public String getMessage() {
        return "Permission Denied!!!";
    }
}
