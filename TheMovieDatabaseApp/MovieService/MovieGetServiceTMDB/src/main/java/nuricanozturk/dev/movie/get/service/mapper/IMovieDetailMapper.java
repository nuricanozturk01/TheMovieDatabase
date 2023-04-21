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

    default MovieWithDetailStringDTO toMovieWithDetailsStringDTO(MovieDetails root, ProductionCompanyDTO productionCompanies, ProductionCountryDTO productionCountries,
                                                             GenreDTO genres)
    {

        var dto = new MovieWithDetailStringDTO();
        dto.id = root.id;
        dto.title = root.title;
        dto.genres = genres.name;
        dto.production_companies = productionCompanies.name;
        dto.production_countries = productionCountries.name;
        dto.original_language = root.original_language;
        dto.original_title = root.original_title;
        dto.overview = root.overview;
        dto.popularity = root.popularity;;
        dto.poster_path = root.poster_path;
        dto.release_date = root.release_date;
        dto.vote_average = root.vote_average;
        dto.vote_count = root.vote_count;;

        return dto;
    }

}
