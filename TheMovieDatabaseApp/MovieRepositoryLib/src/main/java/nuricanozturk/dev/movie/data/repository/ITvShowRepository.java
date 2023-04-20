package nuricanozturk.dev.movie.data.repository;

import nuricanozturk.dev.movie.data.entity.Movie;
import nuricanozturk.dev.movie.data.entity.TvShow;
import org.springframework.data.repository.CrudRepository;

public interface ITvShowRepository extends CrudRepository<TvShow, Long>
{
}
