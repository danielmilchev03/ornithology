package ornithology.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ornithology.data.entity.SpecieNutrition;

public interface SpecieNutritionRepository extends JpaRepository<SpecieNutrition, Integer> {
}
