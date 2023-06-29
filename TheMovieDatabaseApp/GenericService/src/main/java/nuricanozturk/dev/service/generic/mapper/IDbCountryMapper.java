package nuricanozturk.dev.service.generic.mapper;

import nuricanozturk.dev.dtolib.db.genericdtos.ProductionCompaniesDTO;
import nuricanozturk.dev.dtolib.db.genericdtos.ProductionCompanyDTO;
import nuricanozturk.dev.dtolib.db.genericdtos.ProductionCountriesDTO;
import nuricanozturk.dev.dtolib.db.genericdtos.ProductionCountryDTO;
import nuricanozturk.dev.repository.generic.data.entity.ProductionCompany;
import nuricanozturk.dev.repository.generic.data.entity.ProductionCountry;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(implementationName = "DbCountryMapperImpl", componentModel = "spring")
public interface IDbCountryMapper
{
    ProductionCountryDTO toProductionCountryDTO(ProductionCountry productionCountry);
    default ProductionCountriesDTO toProductionCountriesDTO(List<ProductionCountryDTO> productionCountryDTOS)
    {
        var dto = new ProductionCountriesDTO();
        dto.production_countries = productionCountryDTOS;
        return dto;
    }
}
