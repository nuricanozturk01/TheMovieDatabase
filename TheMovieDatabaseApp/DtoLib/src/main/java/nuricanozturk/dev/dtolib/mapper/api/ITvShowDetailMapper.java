package nuricanozturk.dev.dtolib.mapper.api;

import nuricanozturk.dev.dtolib.api.tvshowdto.TvShowDetailDTO;
import nuricanozturk.dev.dtolib.api.tvshowdto.TvShowDetailWrapperDTO;
import nuricanozturk.dev.dtolib.api.tvshowdto.TvShowDetailsDTO;
import nuricanozturk.dev.dtolib.entity.api.tv.TvShowDetailRoot;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(implementationName = "TvShowDetailMapperImpl", componentModel = "spring")
public interface ITvShowDetailMapper {
    List<TvShowDetailDTO> toTvShowDetailDTO(List<TvShowDetailRoot> results);
    TvShowDetailDTO toTvShowDetailDTO(TvShowDetailRoot root);

    default TvShowDetailWrapperDTO toTvShowDetailWrapperDTO(TvShowDetailDTO tvShowDetailDTO) {
        var dto = new TvShowDetailWrapperDTO();

        dto.tv_show_detail = tvShowDetailDTO;
        return dto;
    }

    default TvShowDetailsDTO toTvShowDetailsDTO(List<TvShowDetailDTO> tvShowDtos) {
        var dto = new TvShowDetailsDTO();
        dto.tv_show_details = tvShowDtos;
        return dto;
    }
}
