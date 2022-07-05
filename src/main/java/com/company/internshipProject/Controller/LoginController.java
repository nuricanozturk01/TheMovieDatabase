package com.company.internshipProject.Controller;


import com.company.internshipProject.Authentication.TokenManager;
import com.company.internshipProject.Entity.Userr;
import com.company.internshipProject.Exceptions.UserExceptions.InvalidUserException;
import com.company.internshipProject.Service.IUserService;

import com.company.internshipProject.util.Hash;
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
    public static Userr USER ;
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
    public ResponseEntity<String> loginUser(@RequestBody Userr userr)
    {
        try
        {
            userr.setPassword(Hash.hashing(userr.getPassword()));

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userr.getUsername(), userr.getPassword()));

            String token = tokenManager.generateToken(userr.getUsername());

            loginService.addToken(token,userr.getUsername());

            USER = loginService.getUserByUsername(userr.getUsername());

            return ResponseEntity.ok(token);
        }
        catch (InvalidUserException e)
        {
            throw new InvalidUserException();
        }
    }

}
