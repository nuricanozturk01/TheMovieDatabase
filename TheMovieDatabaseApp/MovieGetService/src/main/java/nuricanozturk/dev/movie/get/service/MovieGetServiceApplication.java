package nuricanozturk.dev.movie.get.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MovieGetServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieGetServiceApplication.class, args);
	}

}
