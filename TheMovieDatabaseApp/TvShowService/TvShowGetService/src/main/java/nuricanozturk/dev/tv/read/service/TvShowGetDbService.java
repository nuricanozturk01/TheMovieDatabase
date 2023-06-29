package nuricanozturk.dev.tv.read.service;

import nuricanozturk.dev.dtolib.db.genericdtos.*;
import nuricanozturk.dev.dtolib.db.tvshowdto.DbTvShowWithDetailDTO;
import nuricanozturk.dev.dtolib.db.tvshowdto.DbTvShowWithDetailsDTO;
import nuricanozturk.dev.tv.data.dal.TvShowRepositoryHelper;
import nuricanozturk.dev.tv.read.config.ValueConfig;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.StreamSupport;

import static java.lang.String.format;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.joining;

@Service
public class TvShowGetDbService
{
    private final TvShowRepositoryHelper m_repositoryHelper;
    private final RestTemplate m_restTemplate;

    private final ValueConfig m_valueConfig;

    public TvShowGetDbService(TvShowRepositoryHelper repositoryHelper, RestTemplate restTemplate, ValueConfig valueConfig)
    {
        m_repositoryHelper = repositoryHelper;
        m_restTemplate = restTemplate;
        m_valueConfig = valueConfig;
    }

    public DbTvShowWithDetailsDTO findTvShowWithDetailsById(long id)
    {
        return new DbTvShowWithDetailsDTO((List<DbTvShowWithDetailDTO>) prepareTvShows(m_repositoryHelper.findTvShowWithDetailsById(id)));
    }

    public DbTvShowWithDetailsDTO findByCompany(String companyName)
    {
        var companyInfo = m_restTemplate.getForObject(format(m_valueConfig.findCompanyNameUrl, companyName), ProductionCompanyDTO.class);
        var tvShows = m_repositoryHelper.findByCompany(companyInfo.company_id);
        return new DbTvShowWithDetailsDTO((List<DbTvShowWithDetailDTO>) prepareTvShows(tvShows));
    }

    public DbTvShowWithDetailsDTO findByCountry(String countryName)
    {
        var countryInfo = m_restTemplate.getForObject(format(m_valueConfig.findCountryUrl, countryName), ProductionCountryDTO.class);
        var tvShows = m_repositoryHelper.findByCountry(countryInfo.getCountry_id());

        return new DbTvShowWithDetailsDTO((List<DbTvShowWithDetailDTO>) prepareTvShows(tvShows));
    }

    public DbTvShowWithDetailsDTO findByGenre(String genreName)
    {
        var genreInfo = m_restTemplate.getForObject(format(m_valueConfig.findGenreNameUrl, genreName), GenreDbDTO.class);
        var tvShow = m_repositoryHelper.findByGenre(genreInfo.getGenre_id());
        return new DbTvShowWithDetailsDTO((List<DbTvShowWithDetailDTO>) prepareTvShows(tvShow));
    }

    public DbTvShowWithDetailsDTO findByVoteAverageBetween(double start, double end)
    {
        return new DbTvShowWithDetailsDTO((List<DbTvShowWithDetailDTO>) prepareTvShows(m_repositoryHelper.findByVoteAverageBetween(start, end)));
    }

    public DbTvShowWithDetailsDTO findAllWithDetails()
    {
        return new DbTvShowWithDetailsDTO((List<DbTvShowWithDetailDTO>) prepareTvShows(m_repositoryHelper.findAllWithDetails()));
    }

    // error on list size == 0
    public boolean existsById(long id)
    {
        return m_repositoryHelper.existsById(id);
    }

    public long count()
    {
        return m_repositoryHelper.count();
    }


    private Iterable<DbTvShowWithDetailDTO> prepareTvShows(Iterable<DbTvShowWithDetailDTO> tvShows)
    {
        var genreIds = new HashSet<>();
        var companyIds = new HashSet<Long>();
        var countryIds = new HashSet<Long>();

        for (DbTvShowWithDetailDTO show : tvShows) {
            genreIds.addAll(stream(show.genres.split(",")).map(Long::parseLong).toList());
            companyIds.addAll(stream(show.companies.split(",")).map(Long::parseLong).toList());
            countryIds.addAll(stream(show.countries.split(",")).map(Long::parseLong).toList());
        }

        var genres = m_restTemplate.getForObject(format(m_valueConfig.findAllGenreUrl, genreIds.stream()
                .map(String::valueOf).collect(joining(","))), GenresDbDTO.class);
        var companies = m_restTemplate.getForObject(format(m_valueConfig.findAllCompanyUrl, companyIds.stream()
                .map(String::valueOf).collect(joining(","))), ProductionCompaniesDTO.class);
        var countries = m_restTemplate.getForObject(format(m_valueConfig.findAllCountryUrl, countryIds.stream()
                .map(String::valueOf).collect(joining(","))), ProductionCountriesDTO.class);

        return StreamSupport.stream(tvShows.spliterator(), true).peek(show -> convertGenres(show, genres))
                .peek(show -> convertCompanies(show, companies)).peek(show -> convertCountries(show, countries)).toList();
    }

    private void convertCountries(DbTvShowWithDetailDTO show, ProductionCountriesDTO countries)
    {
        var ids = stream(show.countries.split(",")).map(Long::parseLong).toList();
        var countryList = new ArrayList<String>();
        countries.production_countries.stream().filter(c -> ids.contains(c.getCountry_id())).forEach(c -> countryList.add(c.getName()));
        show.countries = String.join(",", countryList);
    }

    private void convertCompanies(DbTvShowWithDetailDTO show, ProductionCompaniesDTO companies)
    {
        var ids = stream(show.companies.split(",")).map(Long::parseLong).toList();
        var countryList = new ArrayList<String>();
        companies.production_companies.stream().filter(c -> ids.contains(c.company_id)).forEach(c -> countryList.add(c.name));
        show.companies = String.join(",", countryList);
    }

    private void convertGenres(DbTvShowWithDetailDTO show, GenresDbDTO genres)
    {
        var ids = stream(show.genres.split(",")).map(Long::parseLong).toList();
        var countryList = new ArrayList<String>();
        genres.genres.stream().filter(c -> ids.contains(c.getGenre_id())).forEach(c -> countryList.add(c.getName()));
        show.genres = String.join(",", countryList);
    }
}
