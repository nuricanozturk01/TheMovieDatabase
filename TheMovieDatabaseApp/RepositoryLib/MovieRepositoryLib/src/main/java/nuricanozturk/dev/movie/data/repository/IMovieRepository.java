package nuricanozturk.dev.movie.data.repository;

import nuricanozturk.dev.dtolib.db.moviedto.MovieWithDetailStringDbDTO;
import nuricanozturk.dev.movie.data.entity.Movie;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
@Lazy
public interface IMovieRepository extends CrudRepository<Movie, Long> {
    @Query("from Movie where vote_average between :begin and :end")
    Iterable<Movie> findByVote_averageBetween(@Param("begin") double begin, @Param("end") double end);

    Iterable<Movie> findByPopularityBetween(double b, double e);

    @Query("from Movie where release_date = :date")
    Iterable<Movie> findByRelease_date(@Param("date") LocalDate date);

    @Query("from Movie where release_date between :begin and :end")
    Iterable<Movie> findByRelease_dateBetween(@Param("begin") LocalDate begin, @Param("end") LocalDate end);

    Iterable<Movie> findByTitle(String title);

    @Query(value = """
            select * from movie m, movie_companies mc where m.movie_id = mc.movie_detail_id and :companyId = mc.company_id
            """, nativeQuery = true)
    Iterable<Movie> findByProductionCompany(@Param("companyId") long companyId);

    @Query(value = """
            select * from movie m, movie_countries mc where m.movie_id = mc.movie_detail_id and :countryId = mc.country_id
            """, nativeQuery = true)
    Iterable<Movie> findByProductionCountry(long countryId);

    @Query(value = "select * from movie m, movie_genres mg where m.movie_id = mg.movie_detail_id and :genreId = mg.movie_genre_id", nativeQuery = true)
    Iterable<Movie> findByGenre(long genreId);

   /* @Query("""
                select new nuricanozturk.dev.dtolib.db.moviedto.MovieWithDetailStringDbDTO(m.movie_id, m.title, m.overview,
                 m.release_date, m.language, m.popularity, m.vote_average, md.poster_path)\s
                from Movie as m join m.movieDetail as md, MovieProductionCountry as pc where m.movie_id = md.movie_detail_id and
                :id = pc.country_id
            """)
    Iterable<MovieWithDetailStringDbDTO> findMoviesByCountryWithDetails(@Param("id") long id);*/
}
