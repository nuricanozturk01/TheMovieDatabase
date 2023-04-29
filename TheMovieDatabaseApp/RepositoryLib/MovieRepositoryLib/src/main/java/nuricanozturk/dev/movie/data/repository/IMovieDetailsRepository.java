package nuricanozturk.dev.movie.data.repository;

import nuricanozturk.dev.movie.data.entity.Movie;
import nuricanozturk.dev.movie.data.entity.MovieDetails;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Lazy
public interface IMovieDetailsRepository extends CrudRepository<MovieDetails, Long>
{
    @Query("from MovieDetails where real_movie_id = :id")
    Optional<MovieDetails> findByReal_movie_id(@Param("id") long id);



}
