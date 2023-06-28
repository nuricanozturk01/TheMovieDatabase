package nuricanozturk.dev.dtolib.mapper.api;

import nuricanozturk.dev.dtolib.api.tvshowdto.TvShowDTO;
import nuricanozturk.dev.dtolib.api.tvshowdto.TvShowsDTO;
import nuricanozturk.dev.dtolib.entity.api.tv.Result;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(implementationName = "TvShowMapperImpl", componentModel = "spring")
public interface ITvShowMapper {
    List<TvShowDTO> toTvShowDTO(List<Result> results);

    default TvShowsDTO toTvShowsDTO(List<TvShowDTO> tvShowDtos) {
        var dto = new TvShowsDTO();
        dto.tv_shows = tvShowDtos;
        return dto;
    }
}
