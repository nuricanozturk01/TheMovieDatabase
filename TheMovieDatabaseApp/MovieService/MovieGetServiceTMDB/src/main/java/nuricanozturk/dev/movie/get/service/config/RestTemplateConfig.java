package nuricanozturk.dev.movie.get.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

@Configuration
@Scope("prototype")
public class RestTemplateConfig
{
    @Bean
    @Scope("prototype")
    public RestTemplate createRestTemplate()
    {
        return new RestTemplate();
    }
}
