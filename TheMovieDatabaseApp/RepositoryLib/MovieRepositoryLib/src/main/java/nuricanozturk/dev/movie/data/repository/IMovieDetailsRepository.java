package nuricanozturk.dev.movie.data.repository;

import nuricanozturk.dev.movie.data.entity.MovieDetails;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Lazy
public interface IMovieDetailsRepository extends CrudRepository<MovieDetails, Long>
{

}
