package ornithology.controllers.api;

import org.springframework.web.bind.annotation.*;
import ornithology.data.entity.Nutrition;
import ornithology.service.NutritionService;

import java.util.List;

@RestController
@RequestMapping("/api/nutrition")
public class NutritionApiController {

    private final NutritionService nutritionService;

    public NutritionApiController(NutritionService nutritionService) {
        this.nutritionService = nutritionService;
    }

    public NutritionService getNutritionService() {
        return nutritionService;
    }

    @GetMapping
    public List<Nutrition> getNutrition(){
        return nutritionService.getNutrition();
    }

    @RequestMapping("/{id}")
    public Nutrition getNutrition(@PathVariable("id") Integer id){
        return nutritionService.getNutrition(id);
    }

    @PostMapping
    public Nutrition createNutrition(@RequestBody Nutrition nutrition){
        return nutritionService.create(nutrition);
    }

    @PutMapping(value = "/{id}")
    public Nutrition updateNutrition(@RequestBody Nutrition nutrition, @PathVariable("id") Integer id){
        return nutritionService.updateNutrition(nutrition, id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteNutrition(@PathVariable Integer id){
        nutritionService.deleteNutrition(id);
    }
}
