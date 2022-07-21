package com.company.internshipProject.PasswordGenerator.PGExceptions;

public class MinimumPasswordSizeException extends Exception
{
    public MinimumPasswordSizeException(int size)
    {
        super("Minimum password size must be higher than "+size+"!");
    }
}
