package nuricanozturk.dev.service.generic.service;

import nuricanozturk.dev.dtolib.api.moviedetaildto.MovieWithDetailStringDTO;
import nuricanozturk.dev.repository.generic.data.entity.Genre;
import nuricanozturk.dev.repository.generic.data.entity.ProductionCompany;
import nuricanozturk.dev.repository.generic.data.entity.ProductionCountry;
import nuricanozturk.dev.repository.generic.repository.IGenreRepository;
import nuricanozturk.dev.repository.generic.repository.IProductionCompanyRepository;
import nuricanozturk.dev.repository.generic.repository.IProductionCountryRepository;
import org.springframework.stereotype.Service;

@Service
public class GenericService
{
    private final IGenreRepository m_genreRepository;
    private final IProductionCountryRepository m_productionCountryRepository;
    private final IProductionCompanyRepository m_productionCompanyRepository;

    public GenericService(IGenreRepository genreRepository, IProductionCountryRepository productionCountryRepository,
                          IProductionCompanyRepository productionCompanyRepository)
    {
        m_genreRepository = genreRepository;
        m_productionCountryRepository = productionCountryRepository;
        m_productionCompanyRepository = productionCompanyRepository;
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
/*
    public int saveGenre(MovieWithDetailStringDTO movieDetailDTO)
    {
        if (isExists(movieDetailDTO))
        {

        }
    }*/
}
