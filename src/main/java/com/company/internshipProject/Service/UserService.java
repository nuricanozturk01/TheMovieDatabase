package com.company.internshipProject.Service;

import com.company.internshipProject.Authentication.TokenManager;
import com.company.internshipProject.Controller.LoginController;
import com.company.internshipProject.DAO.UserDal.IUserDAO;
import com.company.internshipProject.Entity.Movie;
import com.company.internshipProject.Entity.UserEntity;
import com.company.internshipProject.Exceptions.MovieExceptions.JWTErrorException;
import com.company.internshipProject.Exceptions.MovieExceptions.PermissionDeniedException;
import com.company.internshipProject.Exceptions.UserExceptions.InvalidUsernameOrPasswordException;
import com.company.internshipProject.Exceptions.UserExceptions.UserAlreadyExistsException;
import com.company.internshipProject.Exceptions.UserExceptions.UserNotExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class UserService  implements IUserService
{
    private IUserDAO userDal;
    @Autowired
    private TokenManager tokenManager;


    @Autowired
    public UserService(IUserDAO userDal)
    {
        this.userDal = userDal;
    }


    @Override
    @Transactional
    public UserEntity getUserByUsername(String username)
    {
        if (username.isBlank() || username.isEmpty())
            return null;
        return userDal.getUserByUsername(username);
    }

    @Override
    @Transactional
    public List<UserEntity> getAllUsers()
    {
        return userDal.getAllUsers();
    }

    @Override
    @Transactional
    public UserEntity addUser(UserEntity userEntity)
    {

        if (userEntity.getUsername().isEmpty() || userEntity.getUsername().isBlank() ||
            userEntity.getPassword().isBlank() || userEntity.getPassword().isEmpty()
            || userEntity.getUsername() == null || userEntity.getPassword() == null)
            throw new InvalidUsernameOrPasswordException();

        if (isUserExists(userEntity))
            throw new UserAlreadyExistsException();
        return userDal.addUser(userEntity);
    }



    @Override
    public boolean isUserExists(UserEntity userEntity)
    {
        List<UserEntity> users = userDal.getAllUsers();

        for (UserEntity user : users)
            if (user.getUsername().equals(userEntity.getUsername()))
                return true;
        return false;
    }

    @Override
    public Movie addMovieToFavouriteList(UserEntity user, int id)
    {
        UserEntity userEntity = userDal.getUserByUsername(user.getUsername());

        if (userEntity == null)
            throw new UserNotExistsException();

        if (!tokenManager.getUsernameToken(userEntity.getToken()).equals(LoginController.USER.getUsername()))
            throw new JWTErrorException();

        return userDal.addMovieToFavouriteList(user,id);
    }

    @Override
    public List<Movie> getFavouriteMoviesByUsername(String username)
    {
        if (username.isBlank() || username.isEmpty())
            throw new InvalidUsernameOrPasswordException();

        UserEntity user = userDal.getUserByUsername(username);

        if (user == null)
            throw new UserNotExistsException();

        if (!user.getUsername().equals(LoginController.USER.getUsername()))
            throw new PermissionDeniedException();

        if(!tokenManager.getUsernameToken(user.getToken()).equals(LoginController.USER.getUsername()))
            throw new JWTErrorException();

        return userDal.getFavouriteMoviesByUsername(username);
    }

    public String addToken(String token, String username)
    {

        return userDal.addToken(token,username);
    }

    @Override
    public Movie deleteMovieFromFavouriteMovieList(UserEntity user, int movie_id)
    {
        if (movie_id <= 0 || movie_id > Integer.MAX_VALUE)
            throw new InvalidUsernameOrPasswordException();

        UserEntity userEntity = userDal.getUserByUsername(user.getUsername());

        if (userEntity == null)
            throw new UserNotExistsException();

        return userDal.deleteMovieFromFavouriteMovieList(user,movie_id);
    }

}
