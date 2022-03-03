package ornithology.controllers.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ornithology.data.entity.*;
import ornithology.service.*;

import java.util.List;

@Controller
@RequestMapping("/familyView")
public class FamilyViewController {

    private final FamilyService familyService;

    public FamilyViewController(FamilyService familyService) {
        this.familyService = familyService;
    }

    @GetMapping
    public String getFamily(Model model) {
        final List<Family> families = familyService.getFamily();
        model.addAttribute("families", families);
        return "/family/family";
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
    public String showEditFamily(Model model, @PathVariable Integer id) {
        model.addAttribute("family", familyService.getFamily(id));
        return "/family/edit-family";
    }

    @PostMapping("/update/{id}")
    public String updateFamily(Model model, @PathVariable Integer id, Family family) {
        familyService.updateFamily(family, id);
        return "redirect:/familyView";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable Integer id) {
        familyService.deleteFamily(id);
        return "redirect:/familyView";
    }
}

