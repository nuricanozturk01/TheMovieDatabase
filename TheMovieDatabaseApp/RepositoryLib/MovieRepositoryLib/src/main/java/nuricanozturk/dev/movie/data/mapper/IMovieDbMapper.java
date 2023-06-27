package nuricanozturk.dev.movie.data.mapper;

import nuricanozturk.dev.dtolib.db.moviedto.MovieDbDTO;
import nuricanozturk.dev.dtolib.db.moviedto.MoviesDbDTO;
import nuricanozturk.dev.movie.data.entity.Movie;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(implementationName = "MovieDbMapperImpl", componentModel = "spring")
public interface IMovieDbMapper
{
    List<MovieDbDTO> toMovieDbDTO(List<Movie> movies);

    default MoviesDbDTO toMoviesDbDTO(List<MovieDbDTO> movieDbDTOS)
    {
        var dto = new MoviesDbDTO();
        dto.movies = movieDbDTOS;
        return dto;
    }
}
