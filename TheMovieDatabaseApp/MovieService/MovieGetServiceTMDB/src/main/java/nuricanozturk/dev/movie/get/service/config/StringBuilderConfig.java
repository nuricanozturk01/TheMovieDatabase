package nuricanozturk.dev.movie.get.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StringBuilderConfig
{
    @Bean
    public StringBuilder getStringBuilder()
    {
        return new StringBuilder();
    }
}
