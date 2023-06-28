package nuricanozturk.dev.tvshow.get.service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValueConfig {

    @Value("${tmdb.results.details.url}")
    public String tvShowDetailUrl;

    @Value("${tmdb.results.all.url}")
    public String tvShowAllUrl;

    @Value("${tmdb.results.popular.url}")
    public String tvShowPopularUrl;

    @Value("${tmdb.results.search.url}")
    public String tvShowSearchUrl;
}
