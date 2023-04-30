package nuricanozturk.dev.movie.data.dal;

import nuricanozturk.dev.movie.data.repository.IMovieProductionCompanyRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class MovieProductionCompanyServiceHelper
{
    private final IMovieProductionCompanyRepository m_productionCompanyRepository;

    public MovieProductionCompanyServiceHelper(IMovieProductionCompanyRepository productionCompanyRepository)
    {
        m_productionCompanyRepository = productionCompanyRepository;
    }
}