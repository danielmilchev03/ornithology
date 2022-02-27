package ornithology.service.implementation;

import org.springframework.stereotype.Service;
import ornithology.data.entity.Nutrition;
import ornithology.data.entity.SpecieNutrition;
import ornithology.data.repository.SpecieNutritionRepository;
import ornithology.service.SpecieNutritionService;

import java.util.List;

@Service
public class SpecieNutritionImplementation implements SpecieNutritionService {
    private final SpecieNutritionRepository specieNutritionRepository;

    public SpecieNutritionImplementation(SpecieNutritionRepository specieNutritionRepository) {
        this.specieNutritionRepository = specieNutritionRepository;
    }

    public SpecieNutritionRepository getSpecieNutritionRepository() {
        return specieNutritionRepository;
    }

    @Override
    public List<SpecieNutrition> getSpecieNutrition() {
        return specieNutritionRepository.findAll();
    }

    @Override
    public SpecieNutrition getSpecieNutrition(Integer id) {
        return specieNutritionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid specie nutrition id: " + id));
    }

    @Override
    public SpecieNutrition create(SpecieNutrition specieNutrition) {
        return specieNutritionRepository.save(specieNutrition);
    }

    @Override
    public SpecieNutrition updateSpecieNutrition(SpecieNutrition specieNutrition, Nutrition id) {
        specieNutrition.setNutritionId(id);

        return specieNutritionRepository.save(specieNutrition);
    }

    @Override
    public void deleteSpecieNutrition(Integer id) {
        specieNutritionRepository.deleteById(id);
    }
}
