package ornithology.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ornithology.data.entity.BirdClass;

public interface BirdClassRepository extends JpaRepository<BirdClass, Integer> {
}
