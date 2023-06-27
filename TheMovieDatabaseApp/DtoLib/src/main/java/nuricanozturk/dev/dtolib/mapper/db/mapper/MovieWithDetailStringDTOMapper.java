package nuricanozturk.dev.dtolib.mapper.db.mapper;

import nuricanozturk.dev.dtolib.api.moviedetaildto.MovieWithDetailStringDTO;
import nuricanozturk.dev.dtolib.db.moviedto.MovieDbDTO;
import nuricanozturk.dev.dtolib.db.moviedto.MovieDetailDbDTO;
import nuricanozturk.dev.dtolib.db.moviedto.MovieWithDetailStringDbDTO;
import nuricanozturk.dev.dtolib.db.moviedto.MovieWithDetailsStringDbDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieWithDetailStringDTOMapper
{
    public MovieWithDetailStringDbDTO toMovieWithDetailStringDbDTO(MovieDbDTO movieDbDTO, MovieDetailDbDTO movieDetailDbDTO)
    {
        var dto = new MovieWithDetailStringDbDTO();
        dto.movie_detail_id = movieDetailDbDTO.movie_detail_id;
        dto.movie_id = movieDbDTO.movie_id;
        dto.real_movie_id = movieDetailDbDTO.real_movie_id;
        dto.genres = movieDetailDbDTO.genres;
        dto.production_companies = movieDetailDbDTO.production_companies;
        dto.production_countries = movieDetailDbDTO.production_countries;
        dto.language = movieDbDTO.language;
        dto.overview = movieDbDTO.overview;
        dto.popularity = movieDbDTO.popularity;
        dto.release_date = movieDbDTO.release_date;
        dto.vote_average = movieDbDTO.vote_average;
        dto.title = movieDbDTO.title;
        dto.poster_path = movieDetailDbDTO.poster_path;

        return dto;
    }

    public MovieWithDetailsStringDbDTO toMovieWithDetailsStringDTO(List<MovieWithDetailStringDbDTO> movies) {
        var dto = new MovieWithDetailsStringDbDTO();
        dto.movies_with_details = movies;
        return dto;
    }
}
