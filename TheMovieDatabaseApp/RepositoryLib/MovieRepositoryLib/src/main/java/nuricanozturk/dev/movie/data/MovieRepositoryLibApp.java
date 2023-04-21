package nuricanozturk.dev.movie.data;

import nuricanozturk.dev.movie.data.dal.MovieServiceHelper;
import nuricanozturk.dev.movie.data.entity.*;
import nuricanozturk.dev.movie.data.repository.IGenreRepository;
import nuricanozturk.dev.movie.data.repository.IProductionCompanyRepository;
import nuricanozturk.dev.movie.data.repository.IProductionCountryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDate;
import java.util.*;

@SpringBootApplication
@ComponentScan("nuricanozturk.dev")
@EnableJpaRepositories(basePackages = "nuricanozturk.dev")
@EntityScan(basePackages = "nuricanozturk.dev")
public class MovieRepositoryLibApp implements CommandLineRunner
{
    private final MovieServiceHelper m_movieServiceHelper;
    private final IGenreRepository m_genreRepository;
    private final IProductionCountryRepository m_productionCountryRepository;
    private final IProductionCompanyRepository m_productionCompanyRepository;



    public MovieRepositoryLibApp(MovieServiceHelper movieServiceHelper, IGenreRepository genreRepository, IProductionCountryRepository productionCountryRepository, IProductionCompanyRepository productionCompanyRepository)
    {
        m_movieServiceHelper = movieServiceHelper;
        m_genreRepository = genreRepository;
        m_productionCountryRepository = productionCountryRepository;
        m_productionCompanyRepository = productionCompanyRepository;
    }

    public static void main(String[] args)
    {
        SpringApplication.run(MovieRepositoryLibApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception
    {
        var movie = new Movie("tr","Movie2","movie 2 overview",4.5, LocalDate.now(), 3.6);
        var details = new MovieDetails(movie.getMovie_id(), movie.getTitle());
        var pcom = new ProductionCompany("com1");
        var pcon = new ProductionCountry("country1");
        var genre = new Genre("genre1");

        details.setCompanies(List.of(pcom));
        details.setCountries(List.of(pcon));
        details.setGenres(List.of(genre));
        movie.setMovieDetail(details);

        System.out.println(movie.getOverview());
        m_movieServiceHelper.saveMovie(movie);
    }
}
