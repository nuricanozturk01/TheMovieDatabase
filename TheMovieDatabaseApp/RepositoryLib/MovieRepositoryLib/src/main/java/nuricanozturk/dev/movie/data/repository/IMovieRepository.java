package nuricanozturk.dev.movie.data.repository;

import nuricanozturk.dev.movie.data.entity.Movie;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
@Lazy
public interface IMovieRepository extends CrudRepository<Movie, Long>
{
    @Query("from Movie where vote_average between :begin and :end")
    Iterable<Movie> findByVote_averageBetween(@Param("begin") double begin, @Param("end") double end);

    Iterable<Movie> findByPopularityBetween(double b, double e);

    @Query("from Movie where release_date = :date")
    Iterable<Movie> findByRelease_date(@Param("date") LocalDate date);

    @Query("from Movie where release_date between :begin and :end")
    Iterable<Movie> findByRelease_dateBetween(@Param("begin") LocalDate begin, @Param("end") LocalDate end);

    Iterable<Movie> findByTitle(String title);

    /*@Query("""

    
        """)*/
    // TODO: implement this
    //Iterable<Movie> findByProductionCompany(@Param("companyId") long companyId);


}
