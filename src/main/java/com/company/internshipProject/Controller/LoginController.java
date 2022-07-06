package com.company.internshipProject.Controller;


import com.company.internshipProject.Authentication.TokenManager;
import com.company.internshipProject.Entity.UserEntity;
import com.company.internshipProject.Exceptions.UserExceptions.InvalidUserException;
import com.company.internshipProject.Service.IUserService;

import com.company.internshipProject.util.Hash;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController
{
    public static UserEntity USER ;
    private IUserService loginService;
    @Autowired
    private TokenManager tokenManager;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    public LoginController(IUserService loginService)
    {
        this.loginService = loginService;
    }


    @PostMapping("/loginuser")
    public ResponseEntity<String> loginUser(@RequestBody UserEntity userEntity)
    {
        try
        {
            userEntity.setPassword(Hash.hashing(userEntity.getPassword()));

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userEntity.getUsername(), userEntity.getPassword()));

            String token = tokenManager.generateToken(userEntity.getUsername());
            loginService.addToken(token, userEntity.getUsername());

            USER = loginService.getUserByUsername(userEntity.getUsername());

            return ResponseEntity.ok(token);
        }
        catch (InvalidUserException e)
        {
            throw new InvalidUserException();
        }
    }

}
