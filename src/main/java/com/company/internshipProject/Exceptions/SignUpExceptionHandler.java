package com.company.internshipProject.Exceptions;

import com.company.internshipProject.Exceptions.UserExceptions.InvalidUsernameOrPasswordException;
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
           response.setStatus(HttpStatus.NO_CONTENT.value());
           response.setTimeStamp(System.currentTimeMillis());

           return new ResponseEntity<>(response,HttpStatus.NO_CONTENT);
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


}
