package com.company.internshipProject.Exceptions.UserExceptions;

public class MissingUserInformationException extends RuntimeException
{
    @Override
    public String getMessage() {
        return "Please enter the username, password and email!";
    }
}
