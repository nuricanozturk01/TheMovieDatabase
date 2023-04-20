package nuricanozturk.dev.movie.data.repository;

import nuricanozturk.dev.movie.data.entity.Genre;
import nuricanozturk.dev.movie.data.entity.Movie;
import org.springframework.data.repository.CrudRepository;

public interface IGenreRepository extends CrudRepository<Genre, Long>
{
}
