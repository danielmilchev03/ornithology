package ornithology.service.implementation;

import org.springframework.stereotype.Service;
import ornithology.data.entity.Country;
import ornithology.data.entity.Family;
import ornithology.data.repository.CountryRepository;
import ornithology.service.CountryService;

import java.util.List;

@Service
public class CountryImplementation implements CountryService{
    private final CountryRepository countryRepository;

    public CountryImplementation(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public CountryRepository getCountryRepository() {
        return countryRepository;
    }

    @Override
    public List<Country> getCountry() {
        return countryRepository.findAll();
    }

    @Override
    public Country getCountry(Integer id) {
        return countryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid family id: " + id));
    }

    @Override
    public Country create(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Country updateCountry(Country country, Integer id) {
        country.setCountryId(id);

        return countryRepository.save(country);
    }

    @Override
    public void deleteCountry(Integer id) {
        countryRepository.deleteById(id);
    }
}
