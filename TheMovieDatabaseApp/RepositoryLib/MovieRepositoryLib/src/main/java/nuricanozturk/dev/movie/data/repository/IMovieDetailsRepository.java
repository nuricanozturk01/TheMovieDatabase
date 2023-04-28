package nuricanozturk.dev.movie.data.repository;

import nuricanozturk.dev.movie.data.entity.Movie;
import nuricanozturk.dev.movie.data.entity.MovieDetails;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@Lazy
public interface IMovieDetailsRepository extends CrudRepository<MovieDetails, Long>
{

}
