package com.company.internshipProject.Exceptions;

import com.company.internshipProject.Exceptions.MovieExceptions.InvalidMovieIdException;
import com.company.internshipProject.Exceptions.MovieExceptions.InvalidPageNumberException;
import com.company.internshipProject.Exceptions.MovieExceptions.MovieNotExistsException;
import com.company.internshipProject.Exceptions.MovieExceptions.PermissionDeniedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MovieExceptionHandler
{

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleMovieDoesNotExists(MovieNotExistsException e)
    {
        ErrorResponse response = new ErrorResponse();
        response.setMessage(e.getMessage());
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handlePermissionDenied(PermissionDeniedException e)
    {
        ErrorResponse response = new ErrorResponse();
        response.setMessage(e.getMessage());
        response.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
        response.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(response,HttpStatus.NOT_ACCEPTABLE);
    }


    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleInvalidPageNumber(InvalidPageNumberException e)
    {
        ErrorResponse response = new ErrorResponse();
        response.setMessage(e.getMessage());
        response.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
        response.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(response,HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleInvalidMovieId(InvalidMovieIdException e)
    {
        ErrorResponse response = new ErrorResponse();
        response.setMessage(e.getMessage());
        response.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
        response.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(response,HttpStatus.NOT_ACCEPTABLE);
    }
}
