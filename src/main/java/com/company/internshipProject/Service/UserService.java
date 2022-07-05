package com.company.internshipProject.Service;

import com.company.internshipProject.Authentication.TokenManager;
import com.company.internshipProject.Controller.LoginController;
import com.company.internshipProject.Dal.UserDal.IUserDal;
import com.company.internshipProject.Entity.Movie;
import com.company.internshipProject.Entity.Userr;
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
    private IUserDal userDal;
    @Autowired
    private TokenManager tokenManager;


    @Autowired
    public UserService(IUserDal userDal)
    {
        this.userDal = userDal;
    }


    @Override
    @Transactional
    public Userr getUserByUsername(String username)
    {
        if (username.isBlank() || username.isEmpty())
            return null;
        return userDal.getUserByUsername(username);
    }

    @Override
    @Transactional
    public List<Userr> getAllUsers()
    {
        return userDal.getAllUsers();
    }

    @Override
    @Transactional
    public Userr addUser(Userr userr)
    {

        if (userr.getUsername().isEmpty() || userr.getUsername().isBlank() ||
            userr.getPassword().isBlank() || userr.getPassword().isEmpty()
            || userr.getUsername() == null || userr.getPassword() == null)
            throw new InvalidUsernameOrPasswordException();

        if (isUserExists(userr))
            throw new UserAlreadyExistsException();
        return userDal.addUser(userr);
    }



    @Override
    public boolean isUserExists(Userr userr)
    {
        List<Userr> users = userDal.getAllUsers();

        for (Userr user : users)
            if (user.getUsername().equals(userr.getUsername()))
                return true;
        return false;
    }

    @Override
    public Movie addMovieToFavouriteList(Userr user,int id)
    {
        Userr userr = userDal.getUserByUsername(user.getUsername());

        if (userr == null)
            throw new UserNotExistsException();

        if (!tokenManager.getUsernameToken(userr.getToken()).equals(LoginController.USER.getUsername()))
            throw new JWTErrorException();

        return userDal.addMovieToFavouriteList(user,id);
    }

    @Override
    public List<Movie> getFavouriteMoviesByUsername(String username)
    {
        if (username.isBlank() || username.isEmpty())
            throw new InvalidUsernameOrPasswordException();

        Userr user = userDal.getUserByUsername(username);

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
        if (token.isEmpty() || token.isBlank() ||
            username.isBlank() || username.isEmpty())
            throw new JWTErrorException();

        return userDal.addToken(token,username);
    }

    @Override
    public Movie deleteMovieFromFavouriteMovieList(Userr user, int movie_id)
    {
        if (movie_id < 0 || movie_id > Integer.MAX_VALUE)
            throw new InvalidUsernameOrPasswordException();

        Userr userr = userDal.getUserByUsername(user.getUsername());

        if (userr == null)
            throw new UserNotExistsException();

        return userDal.deleteMovieFromFavouriteMovieList(user,movie_id);
    }

}
