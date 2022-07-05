package com.company.internshipProject.Authentication;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.company.internshipProject.Dal.UserDal.IUserDal;
import com.company.internshipProject.Entity.Userr;
import com.company.internshipProject.Exceptions.UserExceptions.InvalidUserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private IUserDal userDal;
    private List<Userr> userList;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    public UserDetailsService(IUserDal userDal) {
        this.userDal = userDal;
    }



    @PostConstruct
    public void init() {
        userList = new ArrayList<>();
        userList = userDal.getAllUsers();
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        for (Userr userr : userList)
            if (userr.getUsername().equals(username))
                return new User(username, passwordEncoder.encode(userr.getPassword()), new ArrayList<>());

        throw new InvalidUserException();
    }
}