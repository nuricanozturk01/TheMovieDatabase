package nuricanozturk.dev.movie.data.repository;

import nuricanozturk.dev.movie.data.entity.ProductionCompany;
import nuricanozturk.dev.movie.data.entity.ProductionCountry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductionCountryRepository extends CrudRepository<ProductionCountry, Long>
{
}
