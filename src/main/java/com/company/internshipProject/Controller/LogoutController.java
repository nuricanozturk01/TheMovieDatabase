package com.company.internshipProject.Controller;

import com.company.internshipProject.Authentication.TokenManager;
import com.company.internshipProject.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logout")
public class LogoutController
{
    @Autowired
    private TokenManager tokenManager;

    private IUserService userService;

    @Autowired
    public LogoutController(IUserService userService)
    {
        this.userService = userService;
    }

    @PostMapping("/logoutuser")
    public String logout()
    {
        if (tokenManager.isExpired(LoginController.USER.getToken()))
        {
            userService.addToken(null,LoginController.USER.getUsername());
            LoginController.USER.setToken(null);
            LoginController.USER = null;
        }
        return "logout successfully!";
    }

}
