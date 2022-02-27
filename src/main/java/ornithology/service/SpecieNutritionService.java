package ornithology.service;

import org.springframework.stereotype.Service;
import ornithology.data.entity.Nutrition;
import ornithology.data.entity.SpecieNutrition;

import java.util.List;

@Service
public interface SpecieNutritionService {
    List<SpecieNutrition> getSpecieNutrition();

    SpecieNutrition getSpecieNutrition(Integer id);

    SpecieNutrition create(SpecieNutrition specieNutrition);

    SpecieNutrition updateSpecieNutrition(SpecieNutrition specieNutrition, Nutrition id);

    void deleteSpecieNutrition(Integer id);
}
