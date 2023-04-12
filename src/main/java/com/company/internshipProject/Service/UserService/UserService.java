package com.company.internshipProject.Service.UserService;

import com.company.internshipProject.Authentication.TokenManager;
import com.company.internshipProject.Controller.AuthController;
import com.company.internshipProject.DAO.UserDAO.IUserDAO;
import com.company.internshipProject.Entity.MovieEntity.Movie;
import com.company.internshipProject.Entity.TVSeriesEntity.TVShow;
import com.company.internshipProject.Entity.UserEntity;
import com.company.internshipProject.Exceptions.MovieExceptions.JWTErrorException;
import com.company.internshipProject.Exceptions.MovieExceptions.PermissionDeniedException;
import com.company.internshipProject.Exceptions.UserExceptions.InvalidUsernameOrPasswordException;
import com.company.internshipProject.Exceptions.UserExceptions.UserAlreadyExistsException;
import com.company.internshipProject.Exceptions.UserExceptions.UserNotExistsException;
import com.company.internshipProject.PasswordGenerator.PasswordGenerator;
import com.company.internshipProject.util.Hash;
import com.company.internshipProject.util.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class UserService implements IUserService
{
    private final IUserDAO userDal;

    @Autowired
    private TokenManager tokenManager;


    public UserService(IUserDAO userDal)
    {
        this.userDal = userDal;
    }

    private UserEntity getUser()
    {
        return getUserByUsername(tokenManager.getUsernameToken(AuthController.TOKEN));
    }
    @Override
    @Transactional
    public UserEntity getUserByUsername(String username)
    {
        return username.isBlank() || username.isEmpty() ? null : userDal.getUserByUsername(username);
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
        var users = userDal.getAllUsers();

        for (UserEntity user : users)
            if (user.getUsername().equals(userEntity.getUsername()))
                return true;
        return false;
    }

    @Override
    public Movie addMovieToFavouriteList(int id)
    {
        var user = userDal.getUserByUsername(tokenManager.getUsernameToken(AuthController.TOKEN));

        if (user == null)
            throw new UserNotExistsException();


        if (!tokenManager.getUsernameToken(user.getToken()).equals(getUser().getUsername()))
            throw new JWTErrorException();

        return userDal.addMovieToFavouriteList(user,id);
    }

    @Override
    public List<Movie> getFavouriteMoviesByUsername()
    {
       var user = getUser();

        if (user == null)
            throw new UserNotExistsException();

        if (!user.getUsername().equals(getUser().getUsername()))
            throw new PermissionDeniedException();

        if(!tokenManager.getUsernameToken(user.getToken()).equals(getUser().getUsername()))
            throw new JWTErrorException();

        return userDal.getFavouriteMoviesByUsername(user);
    }

    public String addToken(String token, String username)
    {
        return userDal.addToken(token,username);
    }

    @Override
    public Movie deleteMovieFromFavouriteMovieList(int movie_id)
    {
        if (movie_id <= 0 || movie_id > Integer.MAX_VALUE)
            throw new InvalidUsernameOrPasswordException();

        var userEntity = userDal.getUserByUsername(getUser().getUsername());

        if (userEntity == null)
            throw new UserNotExistsException();

        return userDal.deleteMovieFromFavouriteMovieList(getUser(),movie_id);
    }

    @Override
    public TVShow addTvShowToFavouriteList(int id)
    {

        var user = getUser();

        if (user == null)
            throw new UserNotExistsException();

        if (!tokenManager.getUsernameToken(user.getToken()).equals(getUser().getUsername()))
            throw new JWTErrorException();

        return userDal.addTvShowToFavouriteList(user,id);
    }


    @Override
    public List<TVShow> getFavouriteSeriesByUsername()
    {
        var user = getUser();

        if (user == null)
            throw new UserNotExistsException();

        if (!user.getUsername().equals(getUser().getUsername()))
            throw new PermissionDeniedException();

        if(!tokenManager.getUsernameToken(user.getToken()).equals(getUser().getUsername()))
            throw new JWTErrorException();
        return userDal.getFavouriteSeriesByUsername(user);
    }
    @Override
    public TVShow deleteSeriesFromFavouriteMovieList(UserEntity user, int tv_show_id) {
        return null;
    }

    @Override
    public void changePassword(UserEntity user)
    {
        var passwordGenerator = new PasswordGenerator(PasswordGenerator.DEFAULT_PASSWORD_SIZE);
        var newPassword = passwordGenerator.randomGenerate();
        Mail.sendMessage(user.getEmail(),"New Password","Your new password is: " + newPassword);;
        userDal.updateUser(user,Hash.hashing(newPassword));
    }
}
