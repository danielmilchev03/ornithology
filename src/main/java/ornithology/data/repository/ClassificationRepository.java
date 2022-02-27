package ornithology.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ornithology.data.entity.Classification;

public interface ClassificationRepository extends JpaRepository<Classification, Integer> {
}
