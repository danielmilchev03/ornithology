package ornithology.controllers.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ornithology.data.entity.*;
import ornithology.service.*;

import java.util.List;

@Controller
@RequestMapping("/genusView")
public class GenusViewController {

    private final GenusService genusService;
    private final UserService userService;
    private final FamilyService familyService;


    public GenusViewController(GenusService genusService, UserService userService, FamilyService familyService) {
        this.genusService = genusService;
        this.userService = userService;
        this.familyService = familyService;
    }

    @GetMapping
    public String getGenus(Model model) {
        final List<Genus> genuses = genusService.getGenus();
        model.addAttribute("genuses", genuses);
        return "/genus/genus";
    }

//    @GetMapping("/create-genus")
//    public String showCreateBirdClassForm(Model model) {
//        model.addAttribute("genus", new Genus());
//        model.addAttribute("families", familyService.getFamily());
//        return "/birdClass/create-bird-class";
//    }
//
//    @PostMapping("/create")
//    public String createGenus(@ModelAttribute Genus genus) {
//        genusService.create(genus);
//        return "redirect:/birdClassView";
//    }

    @GetMapping("/edit/{id}")
    public String showEditGenus(Model model, @PathVariable Integer id) {
        model.addAttribute("genus", genusService.getGenus(id));
        model.addAttribute("families", familyService.getFamily());
        return "/genus/edit-genus";
    }

    @PostMapping("/update/{id}")
    public String updateGenus(Model model, @PathVariable Integer id, Genus genus) {
        User user = userService.getUser(1);
        genus.setUserId(user);
//        Family family = familyService.getFamily(1);
//        genus.setFamilyId(family);
//        System.out.println(family);
        genusService.updateGenus(genus, id);
        return "redirect:/genusView";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable Integer id) {
        genusService.deleteGenus(id);
        return "redirect:/genusView";
    }
}