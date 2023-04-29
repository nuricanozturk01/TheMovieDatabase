package nuricanozturk.dev.repository.generic.repository;


import nuricanozturk.dev.repository.generic.data.entity.Genre;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Lazy
public interface IGenreRepository extends CrudRepository<Genre, Long>
{
    Optional<Genre> findByName(String name);
    boolean existsGenreByName(String name);

}
