package ornithology.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ornithology.data.entity.Family;

public interface FamilyRepository extends JpaRepository<Family, Integer> {
}
