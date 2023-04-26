package nuricanozturk.dev.dtolib.mapper.api;

import nuricanozturk.dev.dtolib.api.moviedto.MovieDTO;
import nuricanozturk.dev.dtolib.api.moviedto.MoviesDTO;
import nuricanozturk.dev.dtolib.entity.api.movie.Result;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(implementationName = "MovieMapperImpl", componentModel = "spring")
public interface IMovieMapper
{
    List<MovieDTO> toMovieDTO (List<Result> results);

    default MoviesDTO toMoviesDTO(List<MovieDTO> movies)
    {
        var dto = new MoviesDTO();
        dto.movies = movies;
        return dto;
    }

}
