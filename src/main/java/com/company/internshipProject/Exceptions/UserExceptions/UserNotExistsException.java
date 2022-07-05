package com.company.internshipProject.Exceptions.UserExceptions;

public class UserNotExistsException extends RuntimeException
{
    @Override
    public String getMessage() {
        return "User does not exists!!!";
    }
}
