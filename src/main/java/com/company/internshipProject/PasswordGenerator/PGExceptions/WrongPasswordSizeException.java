package com.company.internshipProject.PasswordGenerator.PGExceptions;

public class WrongPasswordSizeException extends Exception
{
    public WrongPasswordSizeException()
    {
        super("Lower Count + Upper Count + Special Character Count + Number Count must be equal to Password Size");
    }
}
