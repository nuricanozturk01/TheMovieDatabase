package nuricanozturk.dev.tv.read.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValueConfig
{
    @Value("${generic_lib.find_genre_id}")
    public String getGenresByIdUrl;

    @Value("${generic_lib.find_company_id}")
    public String getProductionCompaniesByIdUrl;

    @Value("${generic_lib.find_country_id}")
    public String getProductionCountryByIdUrl;

    @Value("${generic_lib.find_company_name}")
    public String findCompanyNameUrl;

    @Value("${generic_lib.find_genre_name}")
    public String findGenreNameUrl;

    @Value("${generic_lib.find_country_name}")
    public String findCountryUrl;

    @Value("${generic_lib.find.all.genre}")
    public String findAllGenreUrl;


    @Value("${generic_lib.find.all.company}")
    public String findAllCompanyUrl;

    @Value("${generic_lib.find.all.country}")
    public String findAllCountryUrl;
}
