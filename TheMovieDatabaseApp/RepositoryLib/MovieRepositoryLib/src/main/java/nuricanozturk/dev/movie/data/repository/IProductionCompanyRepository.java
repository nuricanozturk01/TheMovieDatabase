package nuricanozturk.dev.movie.data.repository;

import nuricanozturk.dev.movie.data.entity.ProductionCompany;
import org.springframework.data.repository.CrudRepository;

public interface IProductionCompanyRepository extends CrudRepository<ProductionCompany, Long>
{
}
