package nuricanozturk.dev.tv.post;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"nuricanozturk.dev.tv.data", "nuricanozturk.dev.tv.post"})
public class TvShowSaveServiceApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(TvShowSaveServiceApplication.class, args);
    }

}
