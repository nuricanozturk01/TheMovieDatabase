package nuricanozturk.dev.movie.save;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("nuricanozturk.dev")
@EnableJpaRepositories("nuricanozturk.dev")
@EntityScan("nuricanozturk.dev")
public class MovieSaveServiceApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(MovieSaveServiceApplication.class, args);
    }

}
