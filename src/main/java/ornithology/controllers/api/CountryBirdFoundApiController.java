package ornithology.controllers.api;

import org.springframework.web.bind.annotation.*;
import ornithology.data.entity.Country;
import ornithology.data.entity.CountryBirdFound;
import ornithology.service.CountryBirdFoundService;

import java.util.List;

@RestController
@RequestMapping("/api/country_bird_found")
public class CountryBirdFoundApiController {

    private final CountryBirdFoundService countryBirdFoundService;

    public CountryBirdFoundApiController(CountryBirdFoundService countryBirdFoundService) {
        this.countryBirdFoundService = countryBirdFoundService;
    }

    public CountryBirdFoundService getCountryBirdFoundService() {
        return countryBirdFoundService;
    }

    @GetMapping
    public List<CountryBirdFound> getCountryBirdFound(){
        return countryBirdFoundService.getCountryBirdFound();
    }

    @RequestMapping("/{id}")
    public CountryBirdFound getCountryBirdFound(@PathVariable("id") Integer id){
        return countryBirdFoundService.getCountryBirdFound(id);
    }

    @PostMapping
    public CountryBirdFound createCountryBirdFound(@RequestBody CountryBirdFound countryBirdFound){
        return countryBirdFoundService.create(countryBirdFound);
    }

    @PutMapping(value = "/{id}")
    public CountryBirdFound updateCountryBirdFound(@RequestBody CountryBirdFound countryBirdFound, @PathVariable("id") Country id){
        return countryBirdFoundService.updateCountryBirdFound(countryBirdFound, id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteFamily(@PathVariable Integer id){
        countryBirdFoundService.deleteCountryBirdFound(id);
    }
}
