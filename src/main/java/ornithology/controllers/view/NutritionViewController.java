package ornithology.controllers.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ornithology.data.entity.*;
import ornithology.service.*;

import java.util.List;

@Controller
@RequestMapping("/nutritionView")
public class NutritionViewController {

    private final NutritionService nutritionService;

    public NutritionViewController(NutritionService nutritionService) {
        this.nutritionService = nutritionService;
    }

    @GetMapping
    public String getNutrition(Model model) {
        final List<Nutrition> nutritions = nutritionService.getNutrition();
        model.addAttribute("nutritions", nutritions);
        return "/nutrition/nutrition";
    }

    /*@GetMapping("/create-bird-class")
    public String showCreateBirdClassForm(Model model) {
        model.addAttribute("birdClass", new BirdClass());
        return "/birdClass/create-bird-class";
    }

    @PostMapping("/create")
    public String createBirdClass(@ModelAttribute BirdClass birdClass) {
        birdClassService.create(birdClass);
        return "redirect:/birdClassView";
    }*/

    @GetMapping("/edit/{id}")
    public String showEditNutrition(Model model, @PathVariable Integer id) {
        model.addAttribute("nutrition", nutritionService.getNutrition(id));
        return "/nutrition/edit-nutrition";
    }

    @PostMapping("/update/{id}")
    public String updateNutrition(Model model, @PathVariable Integer id, Nutrition nutrition) {
        nutritionService.updateNutrition(nutrition, id);
        return "redirect:/nutritionView";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable Integer id) {
        nutritionService.deleteNutrition(id);
        return "redirect:/nutritionView";
    }
}

