package nuricanozturk.dev.movie.data.dal;

import nuricanozturk.dev.movie.data.config.MoviesDBRepoConfig;
import nuricanozturk.dev.movie.data.entity.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
@Lazy
public class MovieServiceHelper
{
    private final MoviesDBRepoConfig repositories;

    public MovieServiceHelper(MoviesDBRepoConfig moviesDBRepoConfig)
    {
        repositories = moviesDBRepoConfig;
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

    public Iterable<Movie> getMoviesByProductionCompany(long companyId)
    {
        return repositories.m_movieRepository.findByProductionCompany(companyId);
    }

    public Iterable<Movie> getMoviesByTitle(String title)
    {
        return repositories.m_movieRepository.findByTitle(title);
    }

    public Iterable<Movie> getMoviesByReleaseDate(LocalDate releaseDate)
    {
        return repositories.m_movieRepository.findByRelease_date(releaseDate);
    }

    public Iterable<Movie> getMoviesByReleaseDateBetween(LocalDate begin, LocalDate end)
    {
        return repositories.m_movieRepository.findByRelease_dateBetween(begin, end);
    }

    public Iterable<Movie> getMoviesByPopularity(double begin, double end)
    {
        return repositories.m_movieRepository.findByPopularityBetween(begin, end);
    }

    public Iterable<Movie> getMoviesByVote(double begin, double end)
    {
        return repositories.m_movieRepository.findByVote_averageBetween(begin, end);
    }

    public List<MovieGenres> getMovieGenresByMovieDbId(long id)
    {
        return repositories.m_movieDetailsRepository.findById(id)
                .map(movieDetails -> movieDetails.getGenres().stream().toList())
                .orElse(null);
    }

    public MovieDetails findByMovieDetailId(long id)
    {
        return repositories.m_movieDetailsRepository.findById(id).orElse(null);
    }

    public List<MovieProductionCompany> getMovieProductionCompaniesByMovieDbId(long movieId)
    {
        return repositories.m_movieDetailsRepository.findById(movieId)
                .map(movieDetails -> movieDetails.getProductionCompanies().stream().toList())
                .orElse(null);
    }

    public List<MovieProductionCountry> getMovieProductionCountryByMovieDbId(long movieId)
    {
        return repositories.m_movieDetailsRepository.findById(movieId)
                .map(movieDetails -> movieDetails.getProductionCountries().stream().toList())
                .orElse(null);
    }

    public Iterable<Movie> getMoviesByGenre(long genreId)
    {
        return repositories.m_movieRepository.findByGenre(genreId);
    }

    public Iterable<Movie> getMoviesByProductionCountry(long countryId)
    {
        return repositories.m_movieRepository.findByProductionCountry(countryId);
    }

    public void deleteMovie(long id)
    {
        repositories.m_movieRepository.deleteById(id);
    }
}