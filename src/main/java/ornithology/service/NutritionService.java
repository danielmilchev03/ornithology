package ornithology.service;

import org.springframework.stereotype.Service;
import ornithology.data.entity.Nutrition;

import java.util.List;

@Service
public interface NutritionService {
    List<Nutrition> getNutrition();

    Nutrition getNutrition(Integer id);

    Nutrition create(Nutrition nutrition);

    Nutrition updateNutrition(Nutrition nutrition, Integer id);

    void deleteNutrition(Integer id);
}
