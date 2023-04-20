package com.company.internshipProject.DAO.UserDAO;

import com.company.internshipProject.DAO.EntityManagerFactory;
import com.company.internshipProject.Entity.JSONParser.DetailForMovie.MovieDetail;
import com.company.internshipProject.Entity.JSONParser.TV.DetailOfTV;
import com.company.internshipProject.Entity.MovieEntity.Movie;
import com.company.internshipProject.Entity.TVSeriesEntity.TVDetail;
import com.company.internshipProject.Entity.TVSeriesEntity.TVShow;
import com.company.internshipProject.Entity.TVSeriesEntity.UserHasTvShow;
import com.company.internshipProject.Entity.UserEntity;
import com.company.internshipProject.Exceptions.MovieExceptions.MovieNotExistsException;
import com.company.internshipProject.Service.MovieAPIService.IMovieAPIService;
import com.company.internshipProject.Service.TVSeriesAPIService.ITVSeriesAPIService;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;
import java.util.stream.IntStream;

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
        try {
            return  getAllUsers().stream()
                    .filter(u -> u.getUsername().equals(username))
                    .findFirst()
                    .orElse(null);
        }
        catch (NoResultException ignore) {
        }
        return null;
    }

    @Override
    @Transactional
    public List<UserEntity> getAllUsers()
    {
        var session = entityManager.unwrap(Session.class);
        var theQuery = session.createQuery("from UserEntity ", UserEntity.class);
        session.close();
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public UserEntity addUser(UserEntity userEntity)
    {
        var session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(userEntity);
        session.close();
        return userEntity;
    }


    @Override
    @Transactional
    public String addToken(String token, String username)
    {
        var session = entityManager.unwrap(Session.class);
        var user = getUserByUsername(username);
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
    public List<Movie> getFavouriteMoviesByUsername(UserEntity user)
    {
        return user.getMovies();
    }

    private Movie getMovieByMovieId(int movie_id)
    {
        var session = entityManager.unwrap(Session.class);

        var movie =
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
        var session = entityManager.unwrap(Session.class);

        var movie = isExistsMovie(id);

        if (movie == null)
        {
            var movieDetail = movieService.getMovieDetail(id);
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
        var movie = getMovieByMovieId(movie_id);
        var realUser = getUserByUsername(user.getUsername());

        var session = entityManager.unwrap(Session.class);

        var str =
                "DELETE FROM movie_has_user WHERE movie_id="+movie_id+" AND user_id="+realUser.getUserId();
        var query = session.createSQLQuery(str);

        query.executeUpdate();

        session.close();
        return movie;
    }


    private void saveToMovieHasUser(UserEntity u, Movie movie)
    {
        var session = entityManager.unwrap(Session.class);

        var user = getUserByUsername(u.getUsername());

        if(IntStream.range(0, user.getMovies().size()).
                anyMatch(i -> user.getMovies().get(i).getMovieId() == movie.getMovieId()))
            return;

        movieService.addMovie(user,movie);

        session.saveOrUpdate(movie);

        session.close();
    }


    private Movie isExistsMovie(int id)
    {
        var session = entityManager.unwrap(Session.class);
        var theQuery =
                session.createQuery("from Movie",
                        Movie.class);
        var movies = theQuery.getResultList();

        var result = movies.stream()
                .filter(movie -> movie.getRealMovieId() == id)
                .findFirst()
                .orElse(null);

        session.close();

        return result;
    }
    private TVShow isExistsTvShow(int id)
    {
        var session = entityManager.unwrap(Session.class);
        var theQuery =
                session.createQuery("from TVShow ",
                        TVShow.class);
        var tvShows = theQuery.getResultList();

        var result = tvShows.stream()
                .filter(show -> show.getRealTvShowId() == id)
                .findFirst()
                .orElse(null);

        session.close();

        return result;
    }
    @Override
    public TVShow addTvShowToFavouriteList(UserEntity user, int id)
    {
        var session = entityManager.unwrap(Session.class);
        var tvShow = isExistsTvShow(id);

        if (tvShow == null)
        {
            var detailOfTV = tvService.getDetail(id);
            tvShow = new TVShow(detailOfTV.getId(),detailOfTV.getOriginal_name());
            var detail = new TVDetail(detailOfTV.getOverview(),
                    detailOfTV.getNumber_of_seasons(),
                    detailOfTV.getNumber_of_episodes());
            tvShow.setTvDetails(detail);
        }
        session.saveOrUpdate(tvShow);
        saveTvShowToUser(user.getUsername());
        session.close();
        return tvShow;


    }
    private void saveTvShowToUser(String username)
    {

        var session = entityManager.unwrap(Session.class);

        var userr = getUserByUsername(username);

        // Get last Tv show id from database
        var show = (TVShow) session.createQuery("from TVShow ORDER BY id DESC").getResultList().get(0);

        if (userr.getTvShows() != null)
            if (userr.getTvShows().stream().anyMatch(s -> s.getRealTvShowId() == show.getRealTvShowId()))
                return;

        tvService.addTvShow(userr,show);

        session.saveOrUpdate(new UserHasTvShow(show.getId(), userr.getUserId()));
        session.close();
    }

    @Override
    public List<TVShow> getFavouriteSeriesByUsername(UserEntity user)
    {
        return user.getTvShows();
    }

    @Override
    public TVShow deleteSeriesFromFavouriteMovieList(UserEntity user, int tv_show_id) {
        return null;
    }
    @Override
    @Transactional
    public void updateUser(UserEntity user, String hashedPassword)
    {
        var session = entityManager.unwrap(Session.class);
        user.setPassword(hashedPassword);
        session.update(user);
        session.close();
    }

}
