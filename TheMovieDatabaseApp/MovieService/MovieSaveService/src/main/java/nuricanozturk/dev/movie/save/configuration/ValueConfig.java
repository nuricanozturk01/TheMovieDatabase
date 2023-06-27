package nuricanozturk.dev.movie.save.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ValueConfig
{
    @Value("${generic_lib.find_genre_id}")
    public String findGenreByIdUrl;

    @Value("${generic_lib.find_company_id}")
    public String findCompanyByIdUrl;

    @Value("${generic_lib.find_country_id}")
    public String findCountryByIdUrl;

    @Value("${generic_lib.find_genre_name}")
    public String findGenreByNameUrl;

    @Value("${generic_lib.find_company_name}")
    public String findCompanyByNameUrl;

    @Value("${generic_lib.find_country_name}")
    public String findCountryByNameUrl;

    @Value("${generic_lib.save_genre}")
    public String saveGenreUrl;

    @Value("${generic_lib.save_company}")
    public String saveCompanyUrl;

    @Value("${generic_lib.save_country}")
    public String saveCountryUrl;

    @Value("${generic_lib.hide.genres}")
    public String hideGenresUrl;

    @Value("${generic_lib.hide.companies}")
    public String hideCompaniesUrl;

    @Value("${generic_lib.hide.countries}")
    public String hideCountriesUrl;
    //------------------------------------------------------------------------------------
    @Value("${movie.read.service.find_id.url}")
    public String movieGetUrl;

    @Value("${movie.tmdb_service.find_with_detail.url}")
    public String movieWithDetailUrl;
    @Value("${movie.db.get_service.find_real_id.url}")
    public String movieDetailsUrl;
    @Value("${movie.tmdb_service.movie_detail.full}")
    public String movieFullDetailsUrl;

    @Value("${movie.poster.path.prefix}")
    public String moviePosterPrefix;
}
