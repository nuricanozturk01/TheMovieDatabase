package com.company.internshipProject.Authentication;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.company.internshipProject.DAO.UserDAO.IUserDAO;
import com.company.internshipProject.Entity.UserEntity;
import com.company.internshipProject.Exceptions.UserExceptions.InvalidUserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService
{

    private IUserDAO userDal;
    private List<UserEntity> userList;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    public UserDetailsService(IUserDAO userDal) {
        this.userDal = userDal;
    }

    @PostConstruct
    public void init()
    {
        userList = new ArrayList<>();

    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        var usr = userDal.getAllUsers().stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElseThrow(InvalidUserException::new);

        return new User(username, passwordEncoder.encode(usr.getPassword()), new ArrayList<>());
    }
}