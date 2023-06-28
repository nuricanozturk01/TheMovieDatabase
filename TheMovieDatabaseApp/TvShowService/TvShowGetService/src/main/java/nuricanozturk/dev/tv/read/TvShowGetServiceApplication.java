package nuricanozturk.dev.tv.read;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"nuricanozturk.dev.tv.data", "nuricanozturk.dev.tv.read"})
public class TvShowGetServiceApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(TvShowGetServiceApplication.class, args);
    }

}
