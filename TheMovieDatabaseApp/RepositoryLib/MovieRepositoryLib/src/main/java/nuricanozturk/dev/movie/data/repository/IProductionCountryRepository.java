package nuricanozturk.dev.movie.data.repository;

import nuricanozturk.dev.movie.data.entity.ProductionCompany;
import nuricanozturk.dev.movie.data.entity.ProductionCountry;
import org.springframework.data.repository.CrudRepository;

public interface IProductionCountryRepository extends CrudRepository<ProductionCountry, Long>
{
}
