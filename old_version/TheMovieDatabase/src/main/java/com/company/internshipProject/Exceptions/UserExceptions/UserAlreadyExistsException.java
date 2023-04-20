package com.company.internshipProject.Exceptions.UserExceptions;

public class UserAlreadyExistsException extends RuntimeException
{
    @Override
    public String getMessage() {
        return "User already exists!!!";
    }
}
