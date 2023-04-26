package nuricanozturk.dev.dtolib.mapper.api;

import nuricanozturk.dev.dtolib.api.genredto.GenreDTO;
import nuricanozturk.dev.dtolib.api.genredto.GenresDTO;
import nuricanozturk.dev.dtolib.entity.api.movie.Genre;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(implementationName = "GenreMapperImpl", componentModel = "spring")
public interface IGenreMapper
{
    List<GenreDTO> toGenreDTOList(List<Genre> genres);

    default GenresDTO toGenresDTO(List<GenreDTO> genres)
    {
        var dto = new GenresDTO();
        dto.genres = genres;
        return dto;
    }

    default GenreDTO toGenresStringDTO(List<GenreDTO> genres)
    {
        var sb = new StringBuilder();
        var dto = new GenreDTO();
        genres.forEach(s -> sb.append(s.name).append(","));
        sb.deleteCharAt(sb.length() - 1);
        dto.name = sb.toString();
        return dto;
    }
}
