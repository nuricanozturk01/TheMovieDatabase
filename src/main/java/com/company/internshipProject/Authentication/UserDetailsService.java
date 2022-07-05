package com.company.internshipProject.Authentication;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.company.internshipProject.Dal.UserDal.IUserDal;
import com.company.internshipProject.Entity.UserEntity;
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
    private List<UserEntity> userList;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    public UserDetailsService(IUserDal userDal) {
        this.userDal = userDal;
    }



    @PostConstruct
    public void init() {
        userList = new ArrayList<>();

    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        userList = userDal.getAllUsers();
        for (UserEntity userEntity : userList)
            if (userEntity.getUsername().equals(username))
                return new User(username, passwordEncoder.encode(userEntity.getPassword()), new ArrayList<>());

        throw new InvalidUserException();
    }
}