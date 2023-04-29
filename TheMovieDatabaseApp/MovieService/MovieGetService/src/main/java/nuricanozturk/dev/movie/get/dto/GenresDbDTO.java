package nuricanozturk.dev.movie.get.dto;

import java.util.ArrayList;
import java.util.List;

public class GenresDbDTO
{
    public List<GenreDbDTO> genres;

    public GenresDbDTO()
    {
        genres = new ArrayList<>();
    }
}
