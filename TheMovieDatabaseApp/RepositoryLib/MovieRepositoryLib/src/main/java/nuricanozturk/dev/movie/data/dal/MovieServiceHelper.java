package nuricanozturk.dev.movie.data.dal;

import nuricanozturk.dev.movie.data.entity.Movie;
import nuricanozturk.dev.movie.data.entity.MovieDetails;
import nuricanozturk.dev.movie.data.entity.MovieWithDetails;
import nuricanozturk.dev.movie.data.repository.IMovieDetailsRepository;
import nuricanozturk.dev.movie.data.repository.IMovieRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Lazy
public class MovieServiceHelper
{
    private final IMovieRepository m_movieRepository;
    private final IMovieDetailsRepository m_movieDetailsRepository;

    public MovieServiceHelper(IMovieRepository movieRepository, IMovieDetailsRepository movieDetailsRepository)
    {
        m_movieRepository = movieRepository;
        m_movieDetailsRepository = movieDetailsRepository;
    }

    public Movie saveMovie(Movie movie)
    {
        return m_movieRepository.save(movie);
    }
    public Iterable<Movie> getMovies()
    {
        return m_movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(long id)
    {
        return m_movieRepository.findById(id);
    }

    public Optional<MovieDetails> getMovieDetails(long id)
    {
        return m_movieDetailsRepository.findById(id);
    }

    public MovieWithDetails getMovieWithDetails(long id)
    {
        return m_movieRepository.findMovieWithDetails(id);
    }
}
