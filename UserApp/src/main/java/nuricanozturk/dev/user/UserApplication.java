package nuricanozturk.dev.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class UserApplication {


    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }


}
