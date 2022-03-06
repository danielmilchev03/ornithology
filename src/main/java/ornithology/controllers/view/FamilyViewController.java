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
    private final BirdClassService birdClassService;
    private final UserService userService;

    public FamilyViewController(FamilyService familyService, BirdClassService birdClassService, UserService userService) {
        this.familyService = familyService;
        this.birdClassService = birdClassService;
        this.userService = userService;
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
        BirdClass birdClass = birdClassService.getBirdClass(1);
        family.setClassId(birdClass);
        User user = userService.getUser(1);
        family.setUserId(user);
        familyService.updateFamily(family, id);
        return "redirect:/familyView";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable Integer id) {
        familyService.deleteFamily(id);
        return "redirect:/familyView";
    }
}

