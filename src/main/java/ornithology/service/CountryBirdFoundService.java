package ornithology.service;

import org.springframework.stereotype.Service;
import ornithology.data.entity.Country;
import ornithology.data.entity.CountryBirdFound;

import java.util.List;

@Service
public interface CountryBirdFoundService {
    List<CountryBirdFound> getCountryBirdFound();

    CountryBirdFound getCountryBirdFound(Integer id);

    CountryBirdFound create(CountryBirdFound countryBirdFound);

    CountryBirdFound updateCountryBirdFound(CountryBirdFound countryBirdFound, Country id);

    void deleteCountryBirdFound(Integer id);
}
