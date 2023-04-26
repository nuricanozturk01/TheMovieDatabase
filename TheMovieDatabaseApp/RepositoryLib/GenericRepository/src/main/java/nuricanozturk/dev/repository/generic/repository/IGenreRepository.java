package nuricanozturk.dev.repository.generic.repository;


import nuricanozturk.dev.repository.generic.data.entity.Genre;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Lazy
public interface IGenreRepository extends CrudRepository<Genre, Long>
{
}
