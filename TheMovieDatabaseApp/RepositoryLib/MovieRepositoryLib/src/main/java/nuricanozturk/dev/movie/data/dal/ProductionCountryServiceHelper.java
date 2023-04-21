package nuricanozturk.dev.movie.data.dal;

import nuricanozturk.dev.movie.data.repository.IProductionCountryRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class ProductionCountryServiceHelper
{
    private final IProductionCountryRepository m_productionCountryRepository;

    public ProductionCountryServiceHelper(IProductionCountryRepository productionCountryRepository)
    {
        m_productionCountryRepository = productionCountryRepository;
    }
}
