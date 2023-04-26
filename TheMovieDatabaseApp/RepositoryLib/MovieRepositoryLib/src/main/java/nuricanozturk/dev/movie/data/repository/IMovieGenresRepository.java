package nuricanozturk.dev.movie.data.repository;

import nuricanozturk.dev.movie.data.entity.MovieGenres;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Lazy
public interface IMovieGenresRepository extends CrudRepository<MovieGenres, Long>
{
}
