package com.company.internshipProject.Exceptions.MovieExceptions;

public class JWTErrorException extends RuntimeException
{
    @Override
    public String getMessage() {
        return "JWT Token error!!!";
    }
}
