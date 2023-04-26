package nuricanozturk.dev.movie.get.mapper;


import nuricanozturk.dev.dtolib.db.moviedto.MovieDbDTO;
import nuricanozturk.dev.dtolib.db.moviedto.MoviesDbDTO;
import nuricanozturk.dev.movie.data.entity.Movie;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(implementationName = "MovieDTOMapperImpl", componentModel = "spring")
public interface IMovieDTOMapper
{
    MovieDbDTO toMovieDTO(Movie movie);

    default MoviesDbDTO toMoviesDTO(List<MovieDbDTO> movieDTOS)
    {
        var dto = new MoviesDbDTO();
        dto.movies = movieDTOS;
        return dto;
    }
}
