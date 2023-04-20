package nuricanozturk.dev.movie.data.repository;

import nuricanozturk.dev.movie.data.entity.MovieDetails;
import org.springframework.data.repository.CrudRepository;

public interface IMovieDetailsRepository extends CrudRepository<MovieDetails, Long>
{

}
