package com.company.internshipProject.Controller;

import com.company.internshipProject.Entity.UserEntity;
import com.company.internshipProject.Service.IUserService;
import com.company.internshipProject.util.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signup")
public class SignUpController
{
    private IUserService userService;

    @Autowired
    public SignUpController(IUserService userService)
    {
        this.userService = userService;
    }

    @PostMapping("/add")
    public String addUser(@RequestBody UserEntity userEntity)
    {
        userEntity.setPassword(Hash.hashing(userEntity.getPassword()));
        userService.addUser(userEntity);
        return userEntity.getUsername() + " added successfully!";
    }

}
