package nuricanozturk.dev.service.generic.controller;

import nuricanozturk.dev.repository.generic.data.entity.Genre;
import nuricanozturk.dev.repository.generic.data.entity.ProductionCompany;
import nuricanozturk.dev.repository.generic.data.entity.ProductionCountry;
import nuricanozturk.dev.service.generic.service.GenericService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/generic_lib")
public class GenericServiceController
{
    private final GenericService m_genericService;

    public GenericServiceController(GenericService genericService)
    {
        m_genericService = genericService;
    }

    @GetMapping("find/genre/id")
    public Genre findGenreById(@RequestParam("id") long id)
    {
        return m_genericService.findGenreById(id);
    }

    @GetMapping("find/genre/name")
    public Genre findGenreByName(@RequestParam("n") String name)
    {
        return m_genericService.findGenreByName(name);
    }
    @PostMapping("save/genre")
    public Genre saveGenre(@RequestBody Genre genre)
    {
        return m_genericService.saveGenre(genre);
    }


    @GetMapping("find/company/id")
    public ProductionCompany findProductionCompanyById(@RequestParam("id") long id)
    {
        return m_genericService.findProductionCompanyById(id);
    }

    @GetMapping("find/company/name")
    public ProductionCompany findProductionCompanyByName(@RequestParam("n") String name)
    {
        return m_genericService.findProductionCompanyByName(name);
    }
    @PostMapping("save/company")
    public ProductionCompany saveProductionCompany(@RequestBody ProductionCompany company)
    {
        return m_genericService.saveProductionCompany(company);
    }

    @GetMapping("find/country/id")
    public ProductionCountry findProductionCountryById(@RequestParam("id") long id)
    {
        return m_genericService.findProductionCountryById(id);
    }


    @GetMapping("find/country/name")
    public ProductionCountry findProductionCountryByName(@RequestParam("n") String name)
    {
        return m_genericService.findProductionCountryByName(name);
    }

    @PostMapping("save/country")
    public ProductionCountry saveProductionCountry(@RequestBody ProductionCountry country)
    {
        return m_genericService.saveProductionCountry(country);
    }
}