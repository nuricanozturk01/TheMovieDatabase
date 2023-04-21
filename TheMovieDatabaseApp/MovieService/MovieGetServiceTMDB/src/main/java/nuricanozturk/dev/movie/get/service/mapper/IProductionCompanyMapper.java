package nuricanozturk.dev.movie.get.service.mapper;

import nuricanozturk.dev.movie.get.service.api.entity.ProductionCompany;
import nuricanozturk.dev.movie.get.service.dto.ProductionCompaniesDTO;
import nuricanozturk.dev.movie.get.service.dto.ProductionCompanyDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(implementationName = "ProductionCompanyMapperImpl", componentModel = "spring")
public interface IProductionCompanyMapper
{
    List<ProductionCompanyDTO> toProductionCompanyDTO(List<ProductionCompany> productionCompany);

    default ProductionCompaniesDTO toProductionCompaniesDTO(List<ProductionCompanyDTO> productionCompanies)
    {
        var dto = new ProductionCompaniesDTO();
        dto.productionCompanies = productionCompanies;
        return dto;
    }

    default ProductionCompanyDTO toProductionCompanyStringDTO(List<ProductionCompanyDTO> productionCompanies)
    {

        var dto = new ProductionCompanyDTO();
        var sb = new StringBuilder();
        productionCompanies.forEach(s -> sb.append(s.name).append(","));
        sb.deleteCharAt(sb.length() - 1);
        dto.name = sb.toString();
        return dto;
    }


}
