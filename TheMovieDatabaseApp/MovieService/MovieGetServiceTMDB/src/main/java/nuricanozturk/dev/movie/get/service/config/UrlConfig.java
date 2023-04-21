package nuricanozturk.dev.movie.get.service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UrlConfig
{
    @Value("${tmdb.results.all.url}")
    public String allMoviesUrl;

    @Value("${tmdb.results.details.url}")
    public String movieDetailsUrl;

    @Value("${tmdb.results.popular.url}")
    public String popularMoviesUrl;

    @Value("${tmdb.results.search.url}")
    public String searchMoviesUrl;

    @Value("${tmdb.results.trending.weekly.url}")
    public String trendingMoviesWeeklyUrl;

    @Value("${tmdb.results.trending.daily.url}")
    public String trendingMoviesDailyUrl;

    @Value("${tmdb.results.top_rated.url}")
    public String topRatedMoviesUrl;
}
