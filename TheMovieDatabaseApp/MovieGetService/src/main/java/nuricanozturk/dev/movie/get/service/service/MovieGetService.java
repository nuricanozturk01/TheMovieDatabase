package nuricanozturk.dev.movie.get.service.service;

import nuricanozturk.dev.movie.get.service.api.entity.MovieDetails;
import nuricanozturk.dev.movie.get.service.api.entity.Movies;
import nuricanozturk.dev.movie.get.service.api.entity.Root;
import nuricanozturk.dev.movie.get.service.dto.MovieDetailsDTO;
import nuricanozturk.dev.movie.get.service.mapper.IMovieDetailMapper;
import nuricanozturk.dev.movie.get.service.mapper.IMovieMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class MovieGetService
{
    private final RestTemplate m_restTemplate;
    private final IMovieMapper m_movieMapper;
    private final IMovieDetailMapper m_movieDetailMapper;

    @Value("${tmdb.results.all.url}")
    private String allMoviesUrl;

    @Value("${tmdb.results.details.url}")
    private String movieDetailsUrl;

    @Value("${tmdb.results.popular.url}")
    private String popularMoviesUrl;

    public MovieGetService(RestTemplate restTemplate, IMovieMapper movieMapper, IMovieDetailMapper movieDetailMapper)
    {
        m_restTemplate = restTemplate;
        m_movieMapper = movieMapper;
        m_movieDetailMapper = movieDetailMapper;
    }

    public Movies getMovies(int page)
    {
        return m_movieMapper.toMovies(Objects.requireNonNull(m_restTemplate.<Root>getForObject(String.format(allMoviesUrl, page), Root.class)));
    }

    public MovieDetailsDTO getMovieDetails(int movieId)
    {
        var root = m_restTemplate.getForObject(String.format(movieDetailsUrl, movieId), MovieDetails.class);
        return m_movieDetailMapper.toMovieDetailsDTO(Collections.singletonList(m_movieDetailMapper.toMovieDetailDTO(root)));
    }

    public Movies getPopularMovies(int page)
    {
        return m_movieMapper.toMovies(Objects.requireNonNull(m_restTemplate.<Root>getForObject(String.format(popularMoviesUrl, page), Root.class)));
    }
}
