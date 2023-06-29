package nuricanozturk.dev.service.generic.mapper;

import nuricanozturk.dev.dtolib.db.genericdtos.ProductionCompaniesDTO;
import nuricanozturk.dev.dtolib.db.genericdtos.ProductionCompanyDTO;
import nuricanozturk.dev.repository.generic.data.entity.ProductionCompany;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(implementationName = "DbCompanyMapperImpl", componentModel = "spring")
public interface IDbCompanyMapper
{
    ProductionCompanyDTO toProductionCompanyDTO(ProductionCompany productionCompany);
    default ProductionCompaniesDTO toProductionCompaniesDTO(List<ProductionCompanyDTO> productionCompanyDTOS)
    {
        var dto = new ProductionCompaniesDTO();
        dto.production_companies = productionCompanyDTOS;
        return dto;
    }
}
