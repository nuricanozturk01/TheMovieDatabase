package com.company.internshipProject.Exceptions.UserExceptions;

public class InvalidUserException extends RuntimeException
{
    @Override
    public String getMessage() {
        return "User does not exists!!!";
    }
}
