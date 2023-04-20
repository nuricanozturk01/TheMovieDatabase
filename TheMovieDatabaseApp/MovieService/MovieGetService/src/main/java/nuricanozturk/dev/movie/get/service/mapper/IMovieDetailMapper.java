package nuricanozturk.dev.movie.get.service.mapper;

import nuricanozturk.dev.movie.get.service.api.entity.MovieDetails;
import nuricanozturk.dev.movie.get.service.dto.*;
import org.mapstruct.Mapper;

import java.util.stream.Stream;


@Mapper(implementationName = "MovieDetailMapper", componentModel = "spring")
public interface IMovieDetailMapper
{

    default MovieDetailDTO toMovieDetailsWithSingleCompany(MovieDetails root, ProductionCompaniesDTO productionCompanies, ProductionCountriesDTO productionCountries,
                                                           GenresDTO genres)
    {

        var dto = new MovieDetailDTO();
        dto.id = root.id;
        dto.genres = genres.genres;
        dto.title = root.title;
        dto.production_companies = productionCompanies.productionCompanies;
        dto.production_countries = productionCountries.productionCountries;

        return dto;
    }

    default MovieDetailStringDTO toMovieDetailsStringDTO(MovieDetails root, ProductionCompanyDTO productionCompanies, ProductionCountryDTO productionCountries,
                                                           GenreDTO genres)
    {

        var dto = new MovieDetailStringDTO();
        dto.id = root.id;
        dto.genres = genres.name;
        dto.title = root.title;
        dto.production_companies = productionCompanies.name;
        dto.production_countries = productionCountries.name;

        return dto;
    }

}
