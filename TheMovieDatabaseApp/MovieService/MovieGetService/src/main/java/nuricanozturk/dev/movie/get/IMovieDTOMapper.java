package nuricanozturk.dev.movie.get;


import nuricanozturk.dev.movie.data.entity.Movie;
import nuricanozturk.dev.movie.get.dto.MovieDTO;
import nuricanozturk.dev.movie.get.dto.MoviesDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(implementationName = "MovieDTOMapperImpl", componentModel = "spring")
public interface IMovieDTOMapper
{
    MovieDTO toMovieDTO(Movie movie);

    default MoviesDTO toMoviesDTO(List<MovieDTO> movieDTOS)
    {
        var dto = new MoviesDTO();
        dto.movies = movieDTOS;
        return dto;
    }
}
