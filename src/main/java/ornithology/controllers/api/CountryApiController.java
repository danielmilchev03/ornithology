package ornithology.controllers.api;

import org.springframework.web.bind.annotation.*;
import ornithology.data.entity.Country;
import ornithology.data.entity.Family;
import ornithology.service.CountryService;

import java.util.List;

@RestController
@RequestMapping("/api/country")
public class CountryApiController {

    private final CountryService countryService;

    public CountryApiController(CountryService countryService) {
        this.countryService = countryService;
    }

    public CountryService getCountryService() {
        return countryService;
    }

    @GetMapping
    public List<Country> getCountry(){
        return countryService.getCountry();
    }

    @RequestMapping("/{id}")
    public Country getCountry(@PathVariable("id") Integer id){
        return countryService.getCountry(id);
    }

    @PostMapping
    public Country createCountry(@RequestBody Country country){
        return countryService.create(country);
    }

    @PutMapping(value = "/{id}")
    public Country updateCountry(@RequestBody Country country, @PathVariable("id") Integer id){
        return countryService.updateCountry(country, id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCountry(@PathVariable Integer id){
        countryService.deleteCountry(id);
    }
}
