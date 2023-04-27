package nuricanozturk.dev.movie.data.dal;

import nuricanozturk.dev.movie.data.entity.Movie;
import nuricanozturk.dev.movie.data.entity.MovieDetails;
import nuricanozturk.dev.movie.data.repository.IMovieDetailsRepository;
import nuricanozturk.dev.movie.data.repository.IMovieRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Lazy
public class MovieServiceHelper
{
    private final RepoConfig m_repoConfig;

    public MovieServiceHelper(RepoConfig repoConfig)
    {
        m_repoConfig = repoConfig;
    }

    public Movie saveMovie(Movie movie)
    {
        return m_repoConfig.m_movieRepository.save(movie);
    }
    public Iterable<Movie> getMovies()
    {
        return m_repoConfig.m_movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(long id)
    {
        return m_repoConfig.m_movieRepository.findById(id);
    }

    public Optional<MovieDetails> getMovieDetails(long id)
    {
        return m_repoConfig.m_movieDetailsRepository.findById(id);
    }

}
