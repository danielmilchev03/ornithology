package ornithology.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ornithology.data.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}
