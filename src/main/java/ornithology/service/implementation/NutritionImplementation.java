package ornithology.service.implementation;

import org.springframework.stereotype.Service;
import ornithology.data.entity.Nutrition;
import ornithology.data.repository.NutritionRepository;
import ornithology.service.NutritionService;

import java.util.List;

@Service
public class NutritionImplementation implements NutritionService {
    private final NutritionRepository nutritionRepository;

    public NutritionImplementation(NutritionRepository nutritionRepository) {
        this.nutritionRepository = nutritionRepository;
    }

    public NutritionRepository getNutritionRepository() {
        return nutritionRepository;
    }

    @Override
    public List<Nutrition> getNutrition() {
        return nutritionRepository.findAll();
    }

    @Override
    public Nutrition getNutrition(Integer id) {
        return nutritionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid nutrition id: " + id));
    }

    @Override
    public Nutrition create(Nutrition nutrition) {
        return nutritionRepository.save(nutrition);
    }

    @Override
    public Nutrition updateNutrition(Nutrition nutrition, Integer id) {
        nutrition.setNutritionId(id);

        return nutritionRepository.save(nutrition);
    }

    @Override
    public void deleteNutrition(Integer id) {
        nutritionRepository.deleteById(id);
    }
}
