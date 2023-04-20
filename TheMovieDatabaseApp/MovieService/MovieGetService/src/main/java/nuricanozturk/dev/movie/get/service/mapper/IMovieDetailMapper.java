package nuricanozturk.dev.movie.get.service.mapper;

import nuricanozturk.dev.movie.get.service.api.entity.MovieDetails;
import nuricanozturk.dev.movie.get.service.dto.MovieDetailDTO;
import nuricanozturk.dev.movie.get.service.dto.MovieDetailsDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(implementationName = "MovieDetailMapper", componentModel = "spring")
public interface IMovieDetailMapper
{
    MovieDetailDTO toMovieDetailDTO(MovieDetails movieDetails);

    default MovieDetailsDTO toMovieDetailsDTO(List<MovieDetailDTO> movieDetailDTO)
    {
        var dto = new MovieDetailsDTO();
        dto.movieDetails = movieDetailDTO;
        return dto;
    }
}
