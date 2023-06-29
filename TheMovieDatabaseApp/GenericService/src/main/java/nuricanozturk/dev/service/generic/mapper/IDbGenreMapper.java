package nuricanozturk.dev.service.generic.mapper;

import nuricanozturk.dev.dtolib.db.genericdtos.GenreDbDTO;
import nuricanozturk.dev.dtolib.db.genericdtos.GenresDbDTO;
import nuricanozturk.dev.repository.generic.data.entity.Genre;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(implementationName = "DbGenreMapperImpl", componentModel = "spring")
public interface IDbGenreMapper
{
    GenreDbDTO toGenreDbDTO(Genre genre);
    default GenresDbDTO toGenresDbDTO(List<GenreDbDTO> genreDbDTOList)
    {
        var dto = new GenresDbDTO();
        dto.genres = genreDbDTOList;
        return dto;
    }
}
