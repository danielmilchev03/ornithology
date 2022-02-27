package ornithology.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ornithology.data.entity.BirdFound;

public interface BirdFoundRepository extends JpaRepository<BirdFound, Integer> {
}
