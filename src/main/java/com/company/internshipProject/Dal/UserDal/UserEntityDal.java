package com.company.internshipProject.Dal.UserDal;

import com.company.internshipProject.Dal.EntityManagerFactory;
import com.company.internshipProject.Entity.JSONParser.Detail.Detail;
import com.company.internshipProject.Entity.Movie;
import com.company.internshipProject.Entity.MovieDetail;
import com.company.internshipProject.Entity.Userr;
import com.company.internshipProject.Exceptions.MovieExceptions.MovieNotExistsException;
import com.company.internshipProject.Service.MovieAPIService.IMovieAPIService;
import com.company.internshipProject.Service.MovieAPIService.MovieAPIService;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class UserEntityDal extends EntityManagerFactory implements IUserDal
{

    private IMovieAPIService movieService;




    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public UserEntityDal(EntityManager entityManager, MovieAPIService movieService)
    {
        super(entityManager);
        this.movieService = movieService;
    }


    @Override
    @Transactional
    public Userr getUserByUsername(String username)
    {
        try
        {
            Session session = entityManager.unwrap(Session.class);
            return (Userr) session.createQuery("FROM Userr WHERE username='"+username+"'").getSingleResult();
        }
        catch (NoResultException e)
        {

        }
        return null;
    }

    @Override
    @Transactional
    public List<Userr> getAllUsers()
    {
        Session session = entityManager.unwrap(Session.class);
        Query<Userr> theQuery = session.createQuery("from Userr", Userr.class);
        session.close();
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public Userr addUser(Userr userr)
    {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(userr);
        session.close();
        return userr;
    }

    @Override
    @Transactional
    public List<Movie> getFavouriteMoviesByUsername(String username)
    {
        Userr user = getUserByUsername(username);
        return user.getMovies();
    }

    @Override
    @Transactional
    public String addToken(String token, String username)
    {
        System.out.println(token);
        Session session = entityManager.unwrap(Session.class);
        Userr user = getUserByUsername(username);
        user.setToken(token);
        session.update(user);
        session.close();
        return token;
    }

    @Override
    @Transactional
    public String getToken(String username)
    {
        return getUserByUsername(username).getToken();
    }



    private Movie getMovieByMovieId(int movie_id)
    {
        Session session = entityManager.unwrap(Session.class);

        Movie movie =
                (Movie) session.createQuery("FROM Movie WHERE movieId =" + movie_id).getSingleResult();

        if (movie == null)
            throw new MovieNotExistsException();
        session.close();
        return movie;
    }


    @Override
    @Transactional
    public Movie deleteMovieFromFavouriteMovieList(Userr user, int movie_id)
    {
        Movie movie = getMovieByMovieId(movie_id);
        Session session = entityManager.unwrap(Session.class);
        session.delete(movie);
        session.close();
        return movie;
    }

    private void saveToMovieHasUser(Userr u, Movie movie)
    {
        Session session = entityManager.unwrap(Session.class);

        Userr user = getUserByUsername(u.getUsername());
        user.addMovie(movie);

        session.saveOrUpdate(movie);

        session.close();
    }


    private Movie isExistsMovie(int id)
    {
        Session session = entityManager.unwrap(Session.class);
        Query<Movie> theQuery =
                session.createQuery("from Movie",
                        Movie.class);
        List<Movie> movies = theQuery.getResultList();

        /*if (movies == null || movies.isEmpty())
            throw new MovieNotExistsException();*/
        for (Movie movie : movies)
            if (movie.getRealMovieId() == id)
                return movie;
        session.close();

        return null;
    }
    @Override
    @Transactional
    public Movie addMovieToFavouriteList(Userr user, int id)
    {
        Session session = entityManager.unwrap(Session.class);

        Movie movie = isExistsMovie(id);

        if (movie == null)
        {
            Detail detail = movieService.getMovieDetail(id);
            movie = new Movie(detail.getId(),detail.getTitle());
            movie.setMovieDetails(new MovieDetail(
                    detail.getOverview(),
                    detail.getGenres().get(0).getName(),
                    detail.getProduction_companies().get(0).getName())
                                );
        }

        session.saveOrUpdate(movie);
        saveToMovieHasUser(user,movie);
        session.close();
        return movie;
    }


}
