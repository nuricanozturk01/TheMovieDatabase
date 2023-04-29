package nuricanozturk.dev.movie.get.mapper;


import nuricanozturk.dev.dtolib.db.moviedto.MovieDbDTO;
import nuricanozturk.dev.dtolib.db.moviedto.MovieDetailDbDTO;
import nuricanozturk.dev.dtolib.db.moviedto.MovieDetailsDbDTO;
import nuricanozturk.dev.dtolib.db.moviedto.MoviesDbDTO;
import nuricanozturk.dev.movie.data.entity.Movie;
import nuricanozturk.dev.movie.data.entity.MovieDetails;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(implementationName = "MovieDetailsDTOMapperImpl", componentModel = "spring")
public interface IMovieDetailsDTOMapper
{

}
