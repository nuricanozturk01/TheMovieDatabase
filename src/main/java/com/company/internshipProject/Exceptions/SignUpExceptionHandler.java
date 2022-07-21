package com.company.internshipProject.Exceptions;

import com.company.internshipProject.Exceptions.UserExceptions.InvalidUsernameOrPasswordException;
import com.company.internshipProject.Exceptions.UserExceptions.MissingUserInformationException;
import com.company.internshipProject.Exceptions.UserExceptions.UserAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SignUpExceptionHandler
{
       @ExceptionHandler
       public ResponseEntity<ErrorResponse> handleInvalidUsernameOrPasswordSyntax(InvalidUsernameOrPasswordException e)
       {
           ErrorResponse response = new ErrorResponse();
           response.setMessage(e.getMessage());
           response.setStatus(HttpStatus.NOT_FOUND.value());
           response.setTimeStamp(System.currentTimeMillis());

           return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
       }


    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleUserAlreadyExists(UserAlreadyExistsException e)
    {
        ErrorResponse response = new ErrorResponse();
        response.setMessage(e.getMessage());
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleMissingUserInformation(MissingUserInformationException e)
    {
        ErrorResponse response = new ErrorResponse();
        response.setMessage(e.getMessage());
        response.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
        response.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(response,HttpStatus.NOT_ACCEPTABLE);
    }


}
