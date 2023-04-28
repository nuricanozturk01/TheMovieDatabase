package nuricanozturk.dev.movie.save.mapper;

import nuricanozturk.dev.movie.data.entity.MovieDetails;
import nuricanozturk.dev.movie.data.entity.MovieGenres;
import nuricanozturk.dev.movie.data.entity.MovieProductionCompany;
import nuricanozturk.dev.movie.data.entity.MovieProductionCountry;
import nuricanozturk.dev.movie.save.dto.CompaniesDBDTO;
import nuricanozturk.dev.movie.save.dto.CountriesDBDTO;
import nuricanozturk.dev.movie.save.dto.GenresDBDTO;
import org.mapstruct.Mapper;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(implementationName = "MovieGenreMapper", componentModel = "spring")
public interface IMovieGenreMapper
{
    default Set<MovieGenres> toMovieGenres(GenresDBDTO genresDBDTO, MovieDetails movieDetails)
    {
        return genresDBDTO.genres.stream().map(g -> new MovieGenres(movieDetails,g.getGenre_id())).collect(Collectors.toSet());
    }

    default Set<MovieProductionCompany> toMovieProductionCompanies(CompaniesDBDTO companiesDBDTO, MovieDetails movieDetails)
    {
        return companiesDBDTO.companies
                .stream()
                .map(g -> new MovieProductionCompany(movieDetails, g.getCompany_id()))
                .collect(Collectors.toSet());
    }

    default Set<MovieProductionCountry> toMovieProductionCountries(CountriesDBDTO countriesDBDTO, MovieDetails movieDetails)
    {
        return countriesDBDTO.countries
                .stream()
                .map(g -> new MovieProductionCountry(movieDetails, g.getCountry_id()))
                .collect(Collectors.toSet());
    }

}
