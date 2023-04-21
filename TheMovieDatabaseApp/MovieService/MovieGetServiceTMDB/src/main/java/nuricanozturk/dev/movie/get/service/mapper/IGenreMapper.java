package nuricanozturk.dev.movie.get.service.mapper;

import nuricanozturk.dev.movie.get.service.api.entity.Genre;
import nuricanozturk.dev.movie.get.service.api.entity.ProductionCountry;
import nuricanozturk.dev.movie.get.service.dto.GenreDTO;
import nuricanozturk.dev.movie.get.service.dto.GenresDTO;
import nuricanozturk.dev.movie.get.service.dto.ProductionCountriesDTO;
import nuricanozturk.dev.movie.get.service.dto.ProductionCountryDTO;
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
