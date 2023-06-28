package nuricanozturk.dev.dtolib.mapper.api;

import nuricanozturk.dev.dtolib.api.tvshowdto.TvShowWithDetailDTO;
import nuricanozturk.dev.dtolib.api.tvshowdto.TvShowWithDetailsDTO;
import nuricanozturk.dev.dtolib.entity.api.tv.TvShowDetailRoot;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(implementationName = "TvShowWithDetailMapperImpl", componentModel = "spring")
public interface ITvShowWithDetailMapper
{
    //TvShowWithDetailDTO toTvShowWithDetailDTO(TvShowDetailRoot tvShowDTO);
    default TvShowWithDetailDTO toTvShowWithDetailDTO(TvShowDetailRoot tvShowDTO)
    {
        var dto = new TvShowWithDetailDTO();
        dto.id = tvShowDTO.id;
        dto.genres = tvShowDTO.genres;
        dto.languages = tvShowDTO.languages;
        dto.name = tvShowDTO.name;
        dto.number_of_episodes = tvShowDTO.number_of_episodes;
        dto.number_of_seasons = tvShowDTO.number_of_seasons;
        dto.original_language = tvShowDTO.original_language;
        dto.overview = tvShowDTO.overview;
        dto.popularity = tvShowDTO.popularity;
        dto.poster_path = tvShowDTO.poster_path;
        dto.production_companies = tvShowDTO.production_companies;
        dto.production_countries = tvShowDTO.production_countries;
        dto.vote_average = tvShowDTO.vote_average;
        dto.vote_count = tvShowDTO.vote_count;
        return dto;
    }


    default TvShowWithDetailsDTO toTvShowsDTO(List<TvShowWithDetailDTO> tvShowDtos)
    {
        var dto = new TvShowWithDetailsDTO();
        dto.tv_show_with_details = tvShowDtos;
        return dto;
    }
}
