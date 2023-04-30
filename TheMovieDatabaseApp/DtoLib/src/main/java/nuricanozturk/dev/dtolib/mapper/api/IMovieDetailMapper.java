package nuricanozturk.dev.dtolib.mapper.api;


import nuricanozturk.dev.dtolib.api.genredto.GenreDTO;
import nuricanozturk.dev.dtolib.api.moviedetaildto.MovieDetailStringDTO;
import nuricanozturk.dev.dtolib.api.moviedetaildto.MovieWithDetailStringDTO;
import nuricanozturk.dev.dtolib.api.productioncompanydto.ProductionCompanyDTO;
import nuricanozturk.dev.dtolib.api.productioncountrydto.ProductionCountryDTO;
import nuricanozturk.dev.dtolib.entity.api.movie.MovieDetails;
import org.mapstruct.Mapper;


@Mapper(implementationName = "MovieDetailMapper", componentModel = "spring")
public interface IMovieDetailMapper
{
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
        dto.popularity = root.popularity;
        ;
        dto.poster_path = root.poster_path;
        dto.release_date = root.release_date;
        dto.vote_average = root.vote_average;
        dto.vote_count = root.vote_count;
        ;

        return dto;
    }

}
