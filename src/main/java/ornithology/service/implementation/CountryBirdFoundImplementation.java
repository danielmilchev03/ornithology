package ornithology.service.implementation;

import org.springframework.stereotype.Service;
import ornithology.data.entity.Country;
import ornithology.data.entity.CountryBirdFound;
import ornithology.data.repository.CountryBirdFoundRepository;
import ornithology.service.CountryBirdFoundService;

import java.util.List;

@Service
public class CountryBirdFoundImplementation implements CountryBirdFoundService {
    private final CountryBirdFoundRepository countryBirdFoundRepository;

    public CountryBirdFoundImplementation(CountryBirdFoundRepository countryBirdFoundRepository) {
        this.countryBirdFoundRepository = countryBirdFoundRepository;
    }

    public CountryBirdFoundRepository getCountryBirdFoundRepository() {
        return countryBirdFoundRepository;
    }

    @Override
    public List<CountryBirdFound> getCountryBirdFound() {
        return countryBirdFoundRepository.findAll();
    }

    @Override
    public CountryBirdFound getCountryBirdFound(Integer id) {
        return countryBirdFoundRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid family id: " + id));
    }

    @Override
    public CountryBirdFound create(CountryBirdFound countryBirdFound) {
        return countryBirdFoundRepository.save(countryBirdFound);
    }

    @Override
    public CountryBirdFound updateCountryBirdFound(CountryBirdFound countryBirdFound, Country id) {
        countryBirdFound.setCountryId(id);

        return countryBirdFoundRepository.save(countryBirdFound);
    }

    @Override
    public void deleteCountryBirdFound(Integer id) {
        countryBirdFoundRepository.deleteById(id);
    }
}
