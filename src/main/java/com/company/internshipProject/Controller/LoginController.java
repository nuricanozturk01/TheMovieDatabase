package com.company.internshipProject.Controller;


import com.company.internshipProject.Authentication.TokenManager;
import com.company.internshipProject.Entity.UserEntity;
import com.company.internshipProject.Exceptions.UserExceptions.InvalidUserException;
import com.company.internshipProject.Exceptions.UserExceptions.InvalidUsernameOrPasswordException;
import com.company.internshipProject.Exceptions.UserExceptions.UserNotExistsException;
import com.company.internshipProject.Service.UserService.IUserService;

import com.company.internshipProject.util.Hash;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController
{
    public static String TOKEN;
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

            TOKEN = tokenManager.generateToken(userEntity.getUsername());;

            loginService.addToken(TOKEN, userEntity.getUsername());

            UserEntity user = loginService.getUserByUsername(userEntity.getUsername());

            if (!user.getEmail().equals(userEntity.getEmail()))
                throw new InvalidUserException();

            return ResponseEntity.ok(TOKEN);
        }
        catch (InvalidUserException e)
        {
            throw new InvalidUserException();
        }
    }

    @PostMapping("/changePassword")
    public String changePassword(@RequestBody String userInfo)
    {
        JSONObject obj = new JSONObject(userInfo);

        String username = obj.getString("username");
        String email = obj.getString("email");

        UserEntity user = loginService.getUserByUsername(username);

        if (user == null)
            throw new UserNotExistsException();

        if (!user.getEmail().equals(email))
            throw new InvalidUsernameOrPasswordException();

        loginService.changePassword(user);

        return "New password has been sent to you email address!";
    }

}
