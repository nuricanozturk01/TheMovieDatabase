package nuricanozturk.dev.service.generic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("nuricanozturk.dev")
@EnableJpaRepositories(basePackages = "nuricanozturk.dev")
@EntityScan(basePackages = "nuricanozturk.dev")
public class GenericServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GenericServiceApplication.class, args);
	}

}
