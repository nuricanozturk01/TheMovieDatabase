package com.company.internshipProject.Controller;

import com.company.internshipProject.Authentication.TokenManager;
import com.company.internshipProject.Entity.UserEntity;
import com.company.internshipProject.Service.UserService.IUserService;
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
        UserEntity user = userService.getUserByUsername(tokenManager.getUsernameToken(LoginController.TOKEN));
        if (tokenManager.isExpired(user.getToken()))
        {
            userService.addToken(null,user.getUsername());
            user.setToken(null);
            LoginController.TOKEN = null;

        }
        return "logout successfully!";
    }

}
