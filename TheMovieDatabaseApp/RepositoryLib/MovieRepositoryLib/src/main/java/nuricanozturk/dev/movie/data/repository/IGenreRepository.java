package nuricanozturk.dev.movie.data.repository;

import nuricanozturk.dev.movie.data.entity.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGenreRepository extends CrudRepository<Genre, Long>
{
}
