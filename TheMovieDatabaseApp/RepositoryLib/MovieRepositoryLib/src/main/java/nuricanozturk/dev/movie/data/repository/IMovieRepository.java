package nuricanozturk.dev.movie.data.repository;

import nuricanozturk.dev.movie.data.entity.Movie;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@Lazy
public interface IMovieRepository extends CrudRepository<Movie, Long>
{

    Iterable<Movie> findByGenre(@Param("genre") String genre);

   /* @Query("""
            select new nuricanozturk.dev.movie.data.entity.MovieWithDetails(m.movie_id, m.language,m.title,m.overview,m.popularity,m.release_date,m.vote_average,md.real_movie_id, md.companies, md.countries, md.genres)\s
            from Movie m, MovieDetails md where m.movie_id = md.movie_detail_id
            """)
    MovieWithDetails findMovieWithDetails(@Param("id") long id);*/


}
