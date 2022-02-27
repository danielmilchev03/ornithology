package ornithology.controllers.api;

import org.springframework.web.bind.annotation.*;
import ornithology.data.entity.Nutrition;
import ornithology.data.entity.SpecieNutrition;
import ornithology.service.SpecieNutritionService;

import java.util.List;

@RestController
@RequestMapping("/api/specie_nutrition")
public class SpecieNutritionApiController {

    private final SpecieNutritionService specieNutritionService;

    public SpecieNutritionApiController(SpecieNutritionService specieNutritionService) {
        this.specieNutritionService = specieNutritionService;
    }

    public SpecieNutritionService getSpecieNutritionService() {
        return specieNutritionService;
    }

    @GetMapping
    public List<SpecieNutrition> getSpecieNutrition(){
        return specieNutritionService.getSpecieNutrition();
    }

    @RequestMapping("/{id}")
    public SpecieNutrition getSpecieNutrition(@PathVariable("id") Integer id){
        return specieNutritionService.getSpecieNutrition(id);
    }

    @PostMapping
    public SpecieNutrition createSpecieNutrition(@RequestBody SpecieNutrition specieNutrition){
        return specieNutritionService.create(specieNutrition);
    }

    @PutMapping(value = "/{id}")
    public SpecieNutrition updateSpecieNutrition(@RequestBody SpecieNutrition specieNutrition, @PathVariable("id") Nutrition id){
        return specieNutritionService.updateSpecieNutrition(specieNutrition, id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteSpecieNutrition(@PathVariable Integer id){
        specieNutritionService.deleteSpecieNutrition(id);
    }
}
