package nuricanozturk.dev.movie.data.dal;

import nuricanozturk.dev.movie.data.repository.IProductionCompanyRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class ProductionCompanyServiceHelper
{
    private final IProductionCompanyRepository m_productionCompanyRepository;

    public ProductionCompanyServiceHelper(IProductionCompanyRepository productionCompanyRepository)
    {
        m_productionCompanyRepository = productionCompanyRepository;
    }
}
