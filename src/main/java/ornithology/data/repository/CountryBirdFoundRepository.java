package ornithology.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ornithology.data.entity.CountryBirdFound;

public interface CountryBirdFoundRepository extends JpaRepository<CountryBirdFound, Integer> {
}
