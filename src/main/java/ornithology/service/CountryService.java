package ornithology.service;

import org.springframework.stereotype.Service;
import ornithology.data.entity.Country;

import java.util.List;

@Service
public interface CountryService {
    List<Country> getCountry();

    Country getCountry(Integer id);

    Country create(Country country);

    Country updateCountry(Country country, Integer id);

    void deleteCountry(Integer id);
}
