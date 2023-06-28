package nuricanozturk.dev.tvshow.get.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan("nuricanozturk.dev")
public class TvShowGetServiceTmdbApplication {

    public static void main(String[] args) {
        SpringApplication.run(TvShowGetServiceTmdbApplication.class, args);
    }

}
