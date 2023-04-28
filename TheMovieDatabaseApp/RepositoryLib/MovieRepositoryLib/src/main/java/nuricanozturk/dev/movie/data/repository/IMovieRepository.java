package nuricanozturk.dev.movie.data.repository;

import nuricanozturk.dev.movie.data.entity.Movie;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@Lazy
public interface IMovieRepository extends CrudRepository<Movie, Long>
{
    @Query("from Movie where vote_average between :begin and :end")
    Iterable<Movie> findByVote_averageBetween(@Param("begin") double begin, @Param("end") double end);

}
