package nuricanozturk.dev.repository.generic.repository;


import nuricanozturk.dev.repository.generic.data.entity.ProductionCompany;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Lazy
public interface IProductionCompanyRepository extends CrudRepository<ProductionCompany, Long>
{
}
