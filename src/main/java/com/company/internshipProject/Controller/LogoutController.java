package com.company.internshipProject.Controller;

import com.company.internshipProject.Authentication.TokenManager;
import com.company.internshipProject.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

@RestController
@RequestMapping("/logout")
public class LogoutController
{
    public static boolean isLogout = true;

    @Autowired
    private TokenManager tokenManager;

    @Autowired
    private AuthenticationManager authenticationManager;
    private IUserService userService;

    @Autowired
    public LogoutController(IUserService userService)
    {
        this.userService = userService;
    }


    @PostMapping("/logoutuser")
    public String logout()
    {
        userService.addToken(null,LoginController.USER.getUsername());
        return "logout successfully!";
    }

}
