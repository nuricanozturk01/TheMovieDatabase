package nuricanozturk.dev.movie.get.service.mapper;

import nuricanozturk.dev.movie.get.service.api.entity.Movies;
import nuricanozturk.dev.movie.get.service.api.entity.Root;
import org.mapstruct.Mapper;

@Mapper(implementationName = "MovieMapperImpl", componentModel = "spring")
public interface IMovieMapper
{

    default Movies toMovies(Root root)
    {
       var dto = new Movies();
       dto.m_results = root.m_results;
       return dto;
    }
}
