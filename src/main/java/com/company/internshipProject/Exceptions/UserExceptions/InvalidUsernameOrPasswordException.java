package com.company.internshipProject.Exceptions.UserExceptions;

public class InvalidUsernameOrPasswordException extends RuntimeException
{
    @Override
    public String getMessage()
    {
        return "Your informations must not include blank or must not be empty!";
    }
}
