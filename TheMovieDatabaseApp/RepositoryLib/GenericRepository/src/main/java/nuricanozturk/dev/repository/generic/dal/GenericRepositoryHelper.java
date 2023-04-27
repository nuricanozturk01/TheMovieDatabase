package nuricanozturk.dev.repository.generic.dal;

import nuricanozturk.dev.repository.generic.repository.IGenreRepository;
import nuricanozturk.dev.repository.generic.repository.IProductionCompanyRepository;
import nuricanozturk.dev.repository.generic.repository.IProductionCountryRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class GenericRepositoryHelper
{
    private final IGenreRepository m_genreRepository;
    private final IProductionCompanyRepository m_productionCompanyRepository;
    private final IProductionCountryRepository m_productionCountryRepository;

    public GenericRepositoryHelper(IGenreRepository genreRepository, IProductionCompanyRepository productionCompanyRepository, IProductionCountryRepository productionCountryRepository)
    {
        m_genreRepository = genreRepository;
        m_productionCompanyRepository = productionCompanyRepository;
        m_productionCountryRepository = productionCountryRepository;
    }
}
