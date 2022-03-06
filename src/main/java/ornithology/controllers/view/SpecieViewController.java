package ornithology.controllers.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ornithology.data.entity.*;
import ornithology.service.*;

import java.util.List;

@Controller
@RequestMapping("/specieView")
public class SpecieViewController {

    private final SpecieService specieService;
    private final GenusService genusService;
    private final UserService userService;

    public SpecieViewController(SpecieService specieService, GenusService genusService, UserService userService) {
        this.specieService = specieService;
        this.genusService = genusService;
        this.userService = userService;
    }

    @GetMapping
    public String getSpecie(Model model) {
        final List<Specie> species = specieService.getSpecie();
        model.addAttribute("species", species);
        return "/specie/specie";
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
    public String showEditSpecie(Model model, @PathVariable Integer id) {
        model.addAttribute("specie", specieService.getSpecie(id));
        return "/specie/edit-specie";
    }

    @PostMapping("/update/{id}")
    public String updateSpecie(Model model, @PathVariable Integer id, Specie specie) {
        Genus genus = genusService.getGenus(1);
        specie.setGenusId(genus);
        User user = userService.getUser(1);
        specie.setUserId(user);
        specieService.updateSpecie(specie, id);
        return "redirect:/specieView";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable Integer id) {
        specieService.deleteSpecie(id);
        return "redirect:/specieView";
    }
}