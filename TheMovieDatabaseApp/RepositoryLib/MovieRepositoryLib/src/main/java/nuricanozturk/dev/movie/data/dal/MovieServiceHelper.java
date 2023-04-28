package nuricanozturk.dev.movie.data.dal;

import nuricanozturk.dev.dtolib.db.moviedto.MovieDbDTO;
import nuricanozturk.dev.dtolib.db.moviedto.MoviesDbDTO;
import nuricanozturk.dev.movie.data.entity.Movie;
import nuricanozturk.dev.movie.data.entity.MovieDetails;
import nuricanozturk.dev.movie.data.mapper.IMovieDbMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.StreamSupport;

@Component
@Lazy
public class MovieServiceHelper
{
    private final MoviesDBRepoConfig m_MoviesDB_repoConfig;
    private final IMovieDbMapper movieDbMapper;

    public MovieServiceHelper(MoviesDBRepoConfig moviesDBRepoConfig, IMovieDbMapper movieDbMapper)
    {
        m_MoviesDB_repoConfig = moviesDBRepoConfig;
        this.movieDbMapper = movieDbMapper;
    }

    public Movie saveMovie(Movie movie)
    {
        return m_MoviesDB_repoConfig.m_movieRepository.save(movie);
    }
    public Iterable<Movie> getMovies()
    {
        return m_MoviesDB_repoConfig.m_movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(long id)
    {
        return m_MoviesDB_repoConfig.m_movieRepository.findById(id);
    }

    public Optional<MovieDetails> getMovieDetails(long id)
    {
        return m_MoviesDB_repoConfig.m_movieDetailsRepository.findById(id);
    }

    public MovieDbDTO getMovieWithDetailsById(long id)
    {
        throw new UnsupportedOperationException("TODO");
    }

    public MovieDbDTO getMoviesByGenre(String genre)
    {
        throw new UnsupportedOperationException("TODO");
    }

    public MovieDbDTO getMoviesByProductionCompany(String company)
    {
        throw new UnsupportedOperationException("TODO");
    }


    public MovieDbDTO getMoviesByProductionCountry(String country)
    {
        throw new UnsupportedOperationException("TODO");
    }

    public MovieDbDTO getMoviesByReleaseDate(String releaseDate)
    {
        throw new UnsupportedOperationException("TODO");
    }

    public MovieDbDTO getMoviesByPopularity(double popularity)
    {
        throw new UnsupportedOperationException("TODO");
    }

    public MoviesDbDTO getMoviesByVote(double begin, double end)
    {
        var movies = StreamSupport.stream(m_MoviesDB_repoConfig.m_movieRepository.findByVote_averageBetween(begin ,end).spliterator(), false).toList();

        return movieDbMapper.toMoviesDbDTO(movieDbMapper.toMovieDbDTO(movies));
    }

}
