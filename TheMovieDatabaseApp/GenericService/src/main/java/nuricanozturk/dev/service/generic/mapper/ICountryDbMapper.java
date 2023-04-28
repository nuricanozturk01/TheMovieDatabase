package nuricanozturk.dev.service.generic.mapper;

import nuricanozturk.dev.service.generic.dto.CountriesDBDTO;
import nuricanozturk.dev.repository.generic.data.entity.ProductionCountry;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(implementationName = "CountryDbMapper", componentModel = "spring")
public interface ICountryDbMapper
{
    default CountriesDBDTO toCountryDbDTO(List<ProductionCountry> countries)
    {
        var dto = new CountriesDBDTO();
        dto.countries = countries;
        return dto;
    }
}
