package nuricanozturk.dev.tv.post.config;

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
    @Value("${tv.tmdb.with_detail}")
    public String getTvWithDetails;

    @Value("${tv.tmdb.wrapper.with_detail}")
    public String getTvShowWithDetailWrapper;


    @Value("${tv.poster.path.prefix}")
    public String tvPosterPrefix;

    @Value("${generic_lib.find.all.genre}")
    public String allGenresByIds;

    @Value("${generic_lib.find.all.company}")
    public String allCompaniesByIds;

    @Value("${generic_lib.find.all.country}")
    public String allCountriesByIds;
}
