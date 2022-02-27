package ornithology.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ornithology.data.entity.Specie;

public interface SpecieRepository extends JpaRepository<Specie, Integer> {
}
