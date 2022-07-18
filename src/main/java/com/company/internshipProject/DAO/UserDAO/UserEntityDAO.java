package com.company.internshipProject.DAO.UserDAO;

import com.company.internshipProject.DAO.EntityManagerFactory;
import com.company.internshipProject.Entity.JSONParser.DetailForMovie.MovieDetail;
import com.company.internshipProject.Entity.JSONParser.TV.DetailOfTV;
import com.company.internshipProject.Entity.MovieEntity.Movie;
import com.company.internshipProject.Entity.TVSeriesEntity.TVDetail;
import com.company.internshipProject.Entity.TVSeriesEntity.TVShow;
import com.company.internshipProject.Entity.UserEntity;
import com.company.internshipProject.Exceptions.MovieExceptions.MovieNotExistsException;
import com.company.internshipProject.Service.MovieAPIService.IMovieAPIService;
import com.company.internshipProject.Service.TVSeriesAPIService.ITVSeriesAPIService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class UserEntityDAO extends EntityManagerFactory implements IUserDAO
{

    private IMovieAPIService movieService;
    private ITVSeriesAPIService tvService;




    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public UserEntityDAO(EntityManager entityManager, IMovieAPIService movieService, ITVSeriesAPIService tvService)
    {
        super(entityManager);
        this.movieService = movieService;
        this.tvService = tvService;
    }


    @Override
    @Transactional
    public UserEntity getUserByUsername(String username)
    {
        try
        {
            List<UserEntity> list = getAllUsers();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getUsername().equals(username))
                    return list.get(i);
            }
            //Session session = entityManager.unwrap(Session.class);
            //return (UserEntity) session.createSQLQuery("FROM UserEntity WHERE username='"+username+"';").getSingleResult();
            //return (UserEntity) session.createQuery("FROM UserEntity WHERE username='"+username+"'").getSingleResult();
        }
        catch (NoResultException e)
        {

        }
        return null;
    }

    @Override
    @Transactional
    public List<UserEntity> getAllUsers()
    {
        Session session = entityManager.unwrap(Session.class);
        Query<UserEntity> theQuery = session.createQuery("from UserEntity ", UserEntity.class);
        session.close();
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public UserEntity addUser(UserEntity userEntity)
    {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(userEntity);
        session.close();
        return userEntity;
    }


    @Override
    @Transactional
    public String addToken(String token, String username)
    {
        Session session = entityManager.unwrap(Session.class);
        UserEntity user = getUserByUsername(username);
        user.setToken(token);
        session.saveOrUpdate(user);
        session.close();
        return token;
    }

    @Override
    @Transactional
    public String getToken(String username)
    {
        return getUserByUsername(username).getToken();
    }
















    @Override
    @Transactional
    public List<Movie> getFavouriteMoviesByUsername(String username)
    {
        UserEntity user = getUserByUsername(username);
        return user.getMovies();
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
    public Movie addMovieToFavouriteList(UserEntity user, int id)
    {
        Session session = entityManager.unwrap(Session.class);

        Movie movie = isExistsMovie(id);

        if (movie == null)
        {
            MovieDetail movieDetail = movieService.getMovieDetail(id);
            movie = new Movie(movieDetail.getId(), movieDetail.getTitle());
            movie.setMovieDetails(new com.company.internshipProject.Entity.MovieEntity.MovieDetail(
                    movieDetail.getOverview(),
                    movieDetail.getGenres().get(0).getName(),
                    movieDetail.getProduction_companies().get(0).getName())
            );
        }

        session.saveOrUpdate(movie);
        saveToMovieHasUser(user,movie);
        session.close();
        return movie;
    }

    @Override
    @Transactional
    public Movie deleteMovieFromFavouriteMovieList(UserEntity user, int movie_id)
    {
        Movie movie = getMovieByMovieId(movie_id);
        UserEntity realUser = getUserByUsername(user.getUsername());

        Session session = entityManager.unwrap(Session.class);

        String str =
                "DELETE FROM movie_has_user WHERE movie_id="+movie_id+" AND user_id="+realUser.getUserId();
        Query query = session.createSQLQuery(str);

        query.executeUpdate();

        session.close();
        return movie;
    }


    private void saveToMovieHasUser(UserEntity u, Movie movie)
    {
        Session session = entityManager.unwrap(Session.class);

        UserEntity user = getUserByUsername(u.getUsername());
        System.out.println("In movies user is: " + u.getUsername() + " " + u.getUserId());
        // For prevent duplicate but next time, I will add trigger to database side for this problem.
        //This is temporary solution.
        for (int i = 0; i < user.getMovies().size(); i++)
            if (user.getMovies().get(i).getMovieId() == movie.getMovieId())
                return;

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







































    private TVShow isExistsTvShow(int id)
    {
        Session session = entityManager.unwrap(Session.class);
        Query<TVShow> theQuery =
                session.createQuery("from TVShow ",
                        TVShow.class);
        List<TVShow> tvShows = theQuery.getResultList();

        /*if (movies == null || movies.isEmpty())
            throw new MovieNotExistsException();*/
        for (TVShow show : tvShows)
            if (show.getRealTvShowId() == id)
                return show;
        session.close();

        return null;
    }




    // New
    @Override
    public TVShow addTvShowToFavouriteList(UserEntity user, int id)
    {
        Session session = entityManager.unwrap(Session.class);
        TVShow tvShow = isExistsTvShow(id);

        if (tvShow == null)
        {
            System.out.println("Tv show is null!");
            DetailOfTV detailOfTV = tvService.getDetail(id);
            tvShow = new TVShow(detailOfTV.getId(),detailOfTV.getOriginal_name());
            TVDetail detail = new TVDetail(detailOfTV.getOverview(),
                    detailOfTV.getNumber_of_seasons(),
                    detailOfTV.getNumber_of_episodes());
            tvShow.setTvDetails(detail);
        }
        session.saveOrUpdate(tvShow);
        saveTvShowToUser(user, tvShow);
        session.close();
        return tvShow;


    }

    private void saveTvShowToUser(UserEntity user, TVShow tvShow)
    {
        System.out.println("I am in saveToTvShowToUser");
        Session session = entityManager.unwrap(Session.class);

        UserEntity userr = getUserByUsername(user.getUsername());
        if (userr.getTvShows() != null)
            for (int i = 0; i < userr.getTvShows().size(); i++)
                if (userr.getTvShows().get(i).getRealTvShowId() == tvShow.getId())
                    return;
        TVShow show = (TVShow) session.createQuery("from TVShow ORDER BY id DESC").getResultList().get(0);
        System.out.println(show.getTitle());
        userr.addTvShow(show);
        System.out.println("Added TvShow to User in List");
        session.update(show);
       // session.saveOrUpdate(userr);
        session.close();
    }

    @Override
    public List<TVShow> getFavouriteSeriesByUsername(String username)
    {
        return null;
    }

    @Override
    public TVShow deleteSeriesFromFavouriteMovieList(UserEntity user, int tv_show_id) {
        return null;
    }
}
