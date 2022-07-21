package com.company.internshipProject.Exceptions;

import com.company.internshipProject.Exceptions.TVSeriesExceptions.InvalidTvSeriesIdException;
import com.company.internshipProject.Exceptions.UserExceptions.InvalidUsernameOrPasswordException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TVSeriesExceptionHandler
{
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleInvalidIdForTvSeries(InvalidTvSeriesIdException e)
    {
        ErrorResponse response = new ErrorResponse();
        response.setMessage(e.getMessage());
        response.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
        response.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(response,HttpStatus.NOT_ACCEPTABLE);
    }
}
