package ornithology.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ornithology.data.entity.Nutrition;

public interface NutritionRepository extends JpaRepository<Nutrition, Integer> {
}
