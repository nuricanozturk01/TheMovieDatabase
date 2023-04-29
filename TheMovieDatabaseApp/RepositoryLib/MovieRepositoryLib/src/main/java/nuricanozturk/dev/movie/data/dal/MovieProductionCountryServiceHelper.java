package nuricanozturk.dev.movie.data.dal;

import nuricanozturk.dev.movie.data.repository.IMovieProductionCountryRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class MovieProductionCountryServiceHelper
{
    private final IMovieProductionCountryRepository m_productionCountryRepository;

    public MovieProductionCountryServiceHelper(IMovieProductionCountryRepository productionCountryRepository)
    {
        m_productionCountryRepository = productionCountryRepository;
    }


}
