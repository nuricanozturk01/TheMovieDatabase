package nuricanozturk.dev.service.generic.mapper;

import nuricanozturk.dev.repository.generic.data.entity.Genre;
import nuricanozturk.dev.repository.generic.data.entity.ProductionCompany;
import nuricanozturk.dev.service.generic.dto.CompaniesDBDTO;
import nuricanozturk.dev.service.generic.dto.GenresDBDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(implementationName = "CompanyDbMapper", componentModel = "spring")
public interface ICompanyDbMapper
{
    default CompaniesDBDTO toCompanyDbDTO(List<ProductionCompany> companies)
    {
        var dto = new CompaniesDBDTO();
        dto.companies = companies;
        return dto;
    }
}
