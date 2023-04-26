package nuricanozturk.dev.dtolib.mapper.api;

import nuricanozturk.dev.dtolib.api.productioncountrydto.ProductionCountriesDTO;
import nuricanozturk.dev.dtolib.api.productioncountrydto.ProductionCountryDTO;
import nuricanozturk.dev.dtolib.entity.api.movie.ProductionCountry;
import org.mapstruct.Mapper;

import java.util.List;

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
