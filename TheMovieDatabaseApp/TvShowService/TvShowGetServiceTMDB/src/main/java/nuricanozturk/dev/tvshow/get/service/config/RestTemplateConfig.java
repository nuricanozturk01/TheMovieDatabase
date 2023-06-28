package nuricanozturk.dev.tvshow.get.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    @Scope("prototype")
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
