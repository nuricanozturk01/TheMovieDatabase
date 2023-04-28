package nuricanozturk.dev.service.generic.mapper;

import nuricanozturk.dev.service.generic.dto.GenresDBDTO;
import nuricanozturk.dev.repository.generic.data.entity.Genre;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(implementationName = "GenreDbMapper", componentModel = "spring")
public interface IGenreDbMapper
{
    default GenresDBDTO toGenresDbDTO(List<Genre> genres)
    {
        var dto = new GenresDBDTO();
        dto.genres = genres;
        return dto;
    }
}
