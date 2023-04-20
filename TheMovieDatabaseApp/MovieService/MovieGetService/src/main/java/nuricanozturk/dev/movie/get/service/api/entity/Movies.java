package nuricanozturk.dev.movie.get.service.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Movies
{
    @JsonProperty("all_movies")
    public List<Result> m_results;
}
