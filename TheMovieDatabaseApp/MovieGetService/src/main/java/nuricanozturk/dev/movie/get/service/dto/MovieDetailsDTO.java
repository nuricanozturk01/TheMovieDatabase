package nuricanozturk.dev.movie.get.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MovieDetailsDTO
{
    @JsonProperty("movie_details")
    public List<MovieDetailDTO> movieDetails;
}
