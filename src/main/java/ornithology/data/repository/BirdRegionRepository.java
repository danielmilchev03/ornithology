package ornithology.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ornithology.data.entity.BirdRegion;

public interface BirdRegionRepository extends JpaRepository<BirdRegion, Integer> {
}
