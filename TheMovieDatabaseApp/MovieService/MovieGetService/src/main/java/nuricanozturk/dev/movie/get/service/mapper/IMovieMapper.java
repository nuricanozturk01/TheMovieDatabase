package nuricanozturk.dev.movie.get.service.mapper;

import nuricanozturk.dev.movie.get.service.api.entity.Result;
import nuricanozturk.dev.movie.get.service.dto.MovieDTO;
import nuricanozturk.dev.movie.get.service.dto.MoviesDTO;
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
