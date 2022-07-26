package com.company.internshipProject.Controller;


import com.company.internshipProject.Authentication.TokenManager;
import com.company.internshipProject.Entity.UserEntity;
import com.company.internshipProject.Exceptions.UserExceptions.InvalidUserException;
import com.company.internshipProject.Exceptions.UserExceptions.InvalidUsernameOrPasswordException;
import com.company.internshipProject.Exceptions.UserExceptions.MissingUserInformationException;
import com.company.internshipProject.Exceptions.UserExceptions.UserNotExistsException;
import com.company.internshipProject.Service.UserService.IUserService;
import com.company.internshipProject.util.ControlUtil;
import com.company.internshipProject.util.Hash;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController
{
    public static String TOKEN;
    private IUserService userService;
    @Autowired
    private TokenManager tokenManager;

    @Autowired
    private AuthenticationManager authenticationManager;

    public AuthController(IUserService userService)
    {
        this.userService = userService;
    }

    @PostMapping("/add")
    public String addUser(@RequestBody UserEntity userEntity)
    {
        if (!ControlUtil.isValidUserForSignUp(userEntity))
            throw new MissingUserInformationException();

        userEntity.setPassword(Hash.hashing(userEntity.getPassword()));
        userService.addUser(userEntity);

        return userEntity.getUsername() + " added successfully!";
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserEntity userEntity)
    {

        try
        {
            userEntity.setPassword(Hash.hashing(userEntity.getPassword()));

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userEntity.getUsername(), userEntity.getPassword()));

            TOKEN = tokenManager.generateToken(userEntity.getUsername());;

            userService.addToken(TOKEN, userEntity.getUsername());

            UserEntity user = userService.getUserByUsername(userEntity.getUsername());

            if (!user.getEmail().equals(userEntity.getEmail()))
                throw new InvalidUserException();

            return ResponseEntity.ok(TOKEN);
        }
        catch (InvalidUserException e)
        {
            throw new InvalidUserException();
        }
    }
/*
    @PostMapping("/logout")
    public String logout()
    {
        UserEntity user = userService.getUserByUsername(tokenManager.getUsernameToken(AuthController.TOKEN));
        if (tokenManager.isExpired(user.getToken()))
        {
            userService.addToken(null,user.getUsername());
            user.setToken(null);
            AuthController.TOKEN = null;

        }
        return "logout successfully!";
    }
*/
    @PostMapping("/changePassword")
    public String changePassword(@RequestBody String userInfo)
    {
        JSONObject obj = new JSONObject(userInfo);

        String username = obj.getString("username");
        String email = obj.getString("email");

        UserEntity user = userService.getUserByUsername(username);

        if (user == null)
            throw new UserNotExistsException();

        if (!user.getEmail().equals(email))
            throw new InvalidUsernameOrPasswordException();

        userService.changePassword(user);

        return "New password has been sent to you email address!";
    }
}
