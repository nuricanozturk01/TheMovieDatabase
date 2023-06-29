package nuricanozturk.dev.tv.post.service;

import nuricanozturk.dev.dtolib.api.tvshowdto.TvShowWithDetailDTO;
import nuricanozturk.dev.tv.data.dal.TvShowRepositoryHelper;
import nuricanozturk.dev.tv.data.dto.ExistsDTO;
import nuricanozturk.dev.tv.data.entity.*;
import nuricanozturk.dev.tv.post.config.ValueConfig;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static java.lang.String.format;

@Service
public class TvShowPostService
{
    private final TvShowRepositoryHelper m_tvShowRepositoryHelper;
    private final RestTemplate m_restTemplate;
    private final ValueConfig m_valueConfig;

    public TvShowPostService(TvShowRepositoryHelper tvShowRepositoryHelper, RestTemplate restTemplate, ValueConfig valueConfig)
    {
        m_tvShowRepositoryHelper = tvShowRepositoryHelper;
        m_restTemplate = restTemplate;
        m_valueConfig = valueConfig;
    }

    public ExistsDTO saveTvShowById(long id) // TMDB id
    {
        var tvShowWithDetailTMDB = m_restTemplate.getForObject(format(m_valueConfig.getTvWithDetails, id), TvShowWithDetailDTO.class);

        var tvShow = new TvShow(tvShowWithDetailTMDB.getId(), tvShowWithDetailTMDB.name, tvShowWithDetailTMDB.original_language,
                tvShowWithDetailTMDB.overview, tvShowWithDetailTMDB.popularity, tvShowWithDetailTMDB.vote_average,
                tvShowWithDetailTMDB.vote_count);

        var savedTvShow = m_tvShowRepositoryHelper.saveTvShow(tvShow);

        System.out.println(savedTvShow.getTv_show_id());
        var tvShowDetails = new TvShowDetails(Math.toIntExact(savedTvShow.getTv_show_id()), tvShowWithDetailTMDB.number_of_episodes, tvShowWithDetailTMDB.number_of_seasons, tvShowWithDetailTMDB.poster_path);
        m_tvShowRepositoryHelper.saveTvShowDetail(tvShowDetails);


        var genres = tvShowWithDetailTMDB.genres;
        genres.stream().map(g -> new TvShowGenre(g.name, tvShowDetails.getTvshow_id())).forEach(m_tvShowRepositoryHelper::saveGenre);
        var companies = tvShowWithDetailTMDB.production_companies;
        companies.stream().map(c -> new TvShowProductionCompany(c.name, tvShowDetails.getTvshow_id())).forEach(m_tvShowRepositoryHelper::saveCompany);
        var countries = tvShowWithDetailTMDB.production_countries;
        countries.stream().map(c -> new TvShowProductionCountry(c.name, tvShowDetails.getTvshow_id())).forEach(m_tvShowRepositoryHelper::saveCountry);

        return new ExistsDTO(false, true);

        //throw new UnsupportedOperationException("NOT IMPLEMENTED YET!");
    }

    public ExistsDTO removeById(long id)
    {
        /*var movie = m_restTemplate.getForObject(format(m_valueConfig.movieDetailsUrl, id), MovieDbDTO.class);
        if (movie != null){
            m_movieServiceHelper.deleteMovie(movie.movie_id);
            return new ExistsDTO(true, false);
        }
        return new ExistsDTO(false, false);*/
        throw new UnsupportedOperationException("NOT IMPLEMENTED YET!");
    }
}
