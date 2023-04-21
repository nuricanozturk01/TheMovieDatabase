package nuricanozturk.dev.movie.get.service.mapper;

import nuricanozturk.dev.movie.get.service.api.entity.ProductionCountry;
import nuricanozturk.dev.movie.get.service.dto.ProductionCountriesDTO;
import nuricanozturk.dev.movie.get.service.dto.ProductionCountryDTO;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Mapper(implementationName = "ProductionCountryMapperImpl", componentModel = "spring")
public interface IProductionCountryMapper
{
    List<ProductionCountryDTO> toProductionCountryDTO(List<ProductionCountry> productionCountry);

    default ProductionCountriesDTO toProductionCountriesDTO(List<ProductionCountryDTO> productionCountries)
    {
        var dto = new ProductionCountriesDTO();
        var sb = new StringBuilder();
        //productionCountries.forEach(s -> sb.append(s.name).append(", "));
        //sb.deleteCharAt(sb.toString().length() - 2);
        dto.productionCountries = productionCountries;
        return dto;
    }

    default ProductionCountryDTO toProductionCountryStringDTO(List<ProductionCountryDTO> productionCountries)
    {
        var dto = new ProductionCountryDTO();
        var sb = new StringBuilder();
        productionCountries.forEach(s -> sb.append(s.name).append(","));
        sb.deleteCharAt(sb.toString().length() - 1);
        dto.name = sb.toString();
        return dto;
    }
}
