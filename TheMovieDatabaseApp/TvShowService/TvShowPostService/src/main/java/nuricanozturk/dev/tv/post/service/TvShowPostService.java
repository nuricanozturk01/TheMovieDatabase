package nuricanozturk.dev.tv.post.service;

import nuricanozturk.dev.dtolib.api.tvshowdto.TvShowWithDetailDTO;
import nuricanozturk.dev.tv.data.dal.TvShowRepositoryHelper;
import nuricanozturk.dev.tv.data.dto.CompaniesDBDTO;
import nuricanozturk.dev.tv.data.dto.CountriesDBDTO;
import nuricanozturk.dev.tv.data.dto.ExistsDTO;
import nuricanozturk.dev.tv.data.dto.GenresDBDTO;
import nuricanozturk.dev.tv.data.entity.*;
import nuricanozturk.dev.tv.post.config.ValueConfig;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Collectors;

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

    public ExistsDTO saveTvShowById(long id)
    {
        var tvShowWithDetailTMDB = m_restTemplate.getForObject(format(m_valueConfig.getTvWithDetails, id), TvShowWithDetailDTO.class);

        var tvShow = new TvShow(tvShowWithDetailTMDB.getId(), tvShowWithDetailTMDB.name, tvShowWithDetailTMDB.original_language,
                tvShowWithDetailTMDB.overview, tvShowWithDetailTMDB.popularity, tvShowWithDetailTMDB.vote_average,
                tvShowWithDetailTMDB.vote_count);

        var savedTvShow = m_tvShowRepositoryHelper.saveTvShow(tvShow);


        var tvShowDetails = new TvShowDetails((int) savedTvShow.getTvshow_id(), tvShowWithDetailTMDB.number_of_episodes,
                tvShowWithDetailTMDB.number_of_seasons, tvShowWithDetailTMDB.poster_path);
        m_tvShowRepositoryHelper.saveTvShowDetail(tvShowDetails);

        saveGenres(tvShowWithDetailTMDB, savedTvShow);
        saveCompanies(tvShowWithDetailTMDB, savedTvShow);
        saveCountries(tvShowWithDetailTMDB, savedTvShow);

        return new ExistsDTO(false, true);
    }

    private void saveCountries(TvShowWithDetailDTO tvShowWithDetailTMDB, TvShow savedTvShow)
    {
        var countryStr = tvShowWithDetailTMDB.production_countries.stream().map(g -> g.name).collect(Collectors.joining(","));


        var countries = m_restTemplate.getForObject(format(m_valueConfig.hideCountriesUrl, countryStr), CountriesDBDTO.class);


        if (countries != null && countries.countries != null)
            countries.countries.stream()
                    .map(g -> new TvShowProductionCountry((int) g.getCountry_id(), (int) savedTvShow.getTvshow_id()))
                    .forEach(m_tvShowRepositoryHelper::saveCountry);
    }

    private void saveCompanies(TvShowWithDetailDTO tvShowWithDetailTMDB, TvShow savedTvShow)
    {
        var companyStr = tvShowWithDetailTMDB.production_companies.stream()
                .map(g -> g.name)
                .collect(Collectors.joining(","));
        var companies = m_restTemplate.getForObject(format(m_valueConfig.hideCompaniesUrl, companyStr), CompaniesDBDTO.class);

        if (companies != null && companies.companies != null)
            companies.companies.stream()
                    .map(g -> new TvShowProductionCompany((int) g.getCompany_id(), (int) savedTvShow.getTvshow_id()))
                    .forEach(m_tvShowRepositoryHelper::saveCompany);
    }

    private void saveGenres(TvShowWithDetailDTO tvShowWithDetailTMDB, TvShow savedTvShow)
    {
        var genreStr = tvShowWithDetailTMDB.genres.stream().map(g -> g.name).collect(Collectors.joining(","));
        var genres = m_restTemplate.getForObject(format(m_valueConfig.hideGenresUrl, genreStr), GenresDBDTO.class);
        if (genres != null && genres.genres != null)
            genres.genres.stream()
                    .map(g -> new TvShowGenre((int) g.getGenre_id(), (int) savedTvShow.getTvshow_id()))
                    .forEach(m_tvShowRepositoryHelper::saveGenre);
    }


    public ExistsDTO removeById(long id)
    {
        var tvShow = m_restTemplate.getForObject(format(m_valueConfig.getTvWithDetails, id), TvShowWithDetailDTO.class);
        if (tvShow != null)
        {
            m_tvShowRepositoryHelper.deleteTvShowById(tvShow.getId());
            return new ExistsDTO(true, false);
        }
        return new ExistsDTO(false, false);
    }
}
