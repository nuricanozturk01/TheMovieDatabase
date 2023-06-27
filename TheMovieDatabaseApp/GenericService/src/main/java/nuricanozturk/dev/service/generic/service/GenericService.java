package nuricanozturk.dev.service.generic.service;

import nuricanozturk.dev.repository.generic.data.entity.Genre;
import nuricanozturk.dev.repository.generic.data.entity.ProductionCompany;
import nuricanozturk.dev.repository.generic.data.entity.ProductionCountry;
import nuricanozturk.dev.repository.generic.repository.IGenreRepository;
import nuricanozturk.dev.repository.generic.repository.IProductionCompanyRepository;
import nuricanozturk.dev.repository.generic.repository.IProductionCountryRepository;
import nuricanozturk.dev.service.generic.dto.CompaniesDBDTO;
import nuricanozturk.dev.service.generic.dto.CountriesDBDTO;
import nuricanozturk.dev.service.generic.dto.GenresDBDTO;
import nuricanozturk.dev.service.generic.mapper.ICompanyDbMapper;
import nuricanozturk.dev.service.generic.mapper.ICountryDbMapper;
import nuricanozturk.dev.service.generic.mapper.IGenreDbMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GenericService
{
    private final IGenreRepository m_genreRepository;

    private final IProductionCountryRepository m_productionCountryRepository;
    private final IProductionCompanyRepository m_productionCompanyRepository;
    private final IGenreDbMapper m_genreDbMapper;
    private final ICompanyDbMapper m_companyDbMapper;
    private final ICountryDbMapper m_countryDbMapper;

    public GenericService(IGenreRepository genreRepository, IProductionCountryRepository productionCountryRepository,
                          IProductionCompanyRepository productionCompanyRepository, IGenreDbMapper genreDbMapper,
                          ICompanyDbMapper companyDbMapper, ICountryDbMapper countryDbMapper)
    {
        m_genreRepository = genreRepository;
        m_productionCountryRepository = productionCountryRepository;
        m_productionCompanyRepository = productionCompanyRepository;
        m_genreDbMapper = genreDbMapper;
        m_companyDbMapper = companyDbMapper;
        m_countryDbMapper = countryDbMapper;
    }

    public Genre findGenreById(long id)
    {
        return m_genreRepository.findById(id).orElse(null);
    }

    public Genre findGenreByName(String name)
    {
        return m_genreRepository.findByName(name).orElse(null);
    }

    public Genre saveGenre(Genre genre)
    {
        return m_genreRepository.save(genre);
    }

    public ProductionCompany findProductionCompanyById(long id)
    {
        return m_productionCompanyRepository.findById(id).orElse(null);
    }

    public ProductionCompany findProductionCompanyByName(String name)
    {
        return m_productionCompanyRepository.findByName(name).orElse(null);
    }

    public ProductionCompany saveProductionCompany(ProductionCompany company)
    {
        return m_productionCompanyRepository.save(company);
    }

    public ProductionCountry findProductionCountryById(long id)
    {
        return m_productionCountryRepository.findById(id).orElse(null);
    }

    public ProductionCountry findProductionCountryByName(String name)
    {
        return m_productionCountryRepository.findByName(name).orElse(null);
    }

    public ProductionCountry saveProductionCountry(ProductionCountry country)
    {
        return m_productionCountryRepository.save(country);
    }

    public GenresDBDTO saveGenreIfNotExistsElseGetId(String genresStr)
    {
        var list = new ArrayList<Genre>();
        var genres = genresStr.split(",");

        for (String genre : genres) {
            var g_genre = findGenreByName(genre);

            if (g_genre != null) {
                list.add(g_genre);
            } else {
                var g = saveGenre(new Genre(genre));

                list.add(g);
            }
        }

        return m_genreDbMapper.toGenresDbDTO(list);
    }

    public CompaniesDBDTO saveCompanyIfNotExistsElseGetId(String companiesStr)
    {
        var list = new ArrayList<ProductionCompany>();
        var companies = companiesStr.split(",");

        for (String s : companies) {
            var company = findProductionCompanyByName(s);

            if (company != null)
                list.add(company);
            else {
                var g = saveProductionCompany(new ProductionCompany(s));
                list.add(g);
            }
        }
        return m_companyDbMapper.toCompanyDbDTO(list);
    }

    public CountriesDBDTO saveCountryIfNotExistsElseGetId(String country)
    {
        var list = new ArrayList<ProductionCountry>();
        var countries = country.split(",");

        for (String s : countries) {
            var c = findProductionCountryByName(s);

            if (c != null)
                list.add(c);
            else {
                var g = saveProductionCountry(new ProductionCountry(s));
                list.add(g);
            }
        }
        return m_countryDbMapper.toCountryDbDTO(list);
    }
}
