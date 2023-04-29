package nuricanozturk.dev.movie.data.dal;

import nuricanozturk.dev.dtolib.db.moviedto.MovieDbDTO;
import nuricanozturk.dev.dtolib.db.moviedto.MoviesDbDTO;
import nuricanozturk.dev.movie.data.config.MoviesDBRepoConfig;
import nuricanozturk.dev.movie.data.entity.*;
import nuricanozturk.dev.movie.data.mapper.IMovieDbMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Component
@Lazy
public class MovieServiceHelper
{
    private final MoviesDBRepoConfig repositories;
    private final IMovieDbMapper movieDbMapper;

    public MovieServiceHelper(MoviesDBRepoConfig moviesDBRepoConfig, IMovieDbMapper movieDbMapper)
    {
        repositories = moviesDBRepoConfig;
        this.movieDbMapper = movieDbMapper;
    }

    public Movie saveMovie(Movie movie)
    {
        return repositories.m_movieRepository.save(movie);
    }
    public Iterable<Movie> getMovies()
    {
        return repositories.m_movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(long id)
    {
        return repositories.m_movieRepository.findById(id);
    }

    public Optional<MovieDetails> getMovieDetails(long id)
    {
        return repositories.m_movieDetailsRepository.findById(id);
    }

    public MovieDbDTO getMovieWithDetailsById(long id)
    {
        throw new UnsupportedOperationException("TODO");
    }

    public MovieDbDTO getMoviesByGenre(String genre)
    {
        throw new UnsupportedOperationException("TODO");
    }

    public MoviesDbDTO getMoviesByProductionCompany(long companyId)
    {

        throw new UnsupportedOperationException("TODO");

    }

    public MoviesDbDTO getMoviesByProductionCountry(String country)
    {
        throw new UnsupportedOperationException("TODO");
    }


    public MoviesDbDTO getMoviesByTitle(String title)
    {
        var movies = StreamSupport.stream(repositories.m_movieRepository.findByTitle(title).spliterator(), false).toList();
        return movieDbMapper.toMoviesDbDTO(movieDbMapper.toMovieDbDTO(movies));
    }

    public MoviesDbDTO getMoviesByReleaseDate(LocalDate releaseDate)
    {
        var movies = StreamSupport.stream(repositories.m_movieRepository.findByRelease_date(releaseDate).spliterator(), false).toList();

        return movieDbMapper.toMoviesDbDTO(movieDbMapper.toMovieDbDTO(movies));
    }

    public MoviesDbDTO getMoviesByReleaseDateBetween(LocalDate begin, LocalDate end)
    {
        var movies = StreamSupport.stream(repositories.m_movieRepository.findByRelease_dateBetween(begin, end).spliterator(), false).toList();

        return movieDbMapper.toMoviesDbDTO(movieDbMapper.toMovieDbDTO(movies));
    }

    public MoviesDbDTO getMoviesByPopularity(double begin, double end)
    {
        var movies = StreamSupport.stream(repositories.m_movieRepository.findByPopularityBetween(begin ,end).spliterator(), false).toList();

        return movieDbMapper.toMoviesDbDTO(movieDbMapper.toMovieDbDTO(movies));
    }

    public MoviesDbDTO getMoviesByVote(double begin, double end)
    {
        var movies = StreamSupport.stream(repositories.m_movieRepository.findByVote_averageBetween(begin ,end).spliterator(), false).toList();

        return movieDbMapper.toMoviesDbDTO(movieDbMapper.toMovieDbDTO(movies));
    }
    public MovieDetails getMovieDetailsByRealMovieId(long id)
    {
        return repositories.m_movieDetailsRepository.findByReal_movie_id(id).orElse(null);
    }

    public List<MovieGenres> getMovieGenresByMovieDbId(long id)
    {
        var details =  repositories.m_movieDetailsRepository.findById(id);

        return details.map(movieDetails -> movieDetails.getGenres().stream().toList()).orElse(null);
    }
    public MovieDetails findByMovieDetailId(long id)
    {
        return repositories.m_movieDetailsRepository.findById(id).orElse(null);
    }

    public List<MovieProductionCompany> getMovieProductionCompaniesByMovieDbId(long movieId)
    {
        var details =  repositories.m_movieDetailsRepository.findById(movieId);

        return details.map(movieDetails -> movieDetails.getProductionCompanies().stream().toList()).orElse(null);
    }

    public List<MovieProductionCountry> getMovieProductionCountryByMovieDbId(long movieId)
    {
        var details =  repositories.m_movieDetailsRepository.findById(movieId);

        return details.map(movieDetails -> movieDetails.getProductionCountries().stream().toList()).orElse(null);
    }
}
