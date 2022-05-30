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

    @GetMapping("/create-specie")
    public String showCreateSpecieForm(Model model) {
        model.addAttribute("specie", new Specie());
        model.addAttribute("genusIds", genusService.getGenus());
        //model.addAttribute("username", userService.getUser());
        return "/specie/create-specie";
    }

    @PostMapping("/create")
    public String createSpecie(@ModelAttribute Specie specie) {
        User user = userService.getUser(1);
        specie.setUserId(user);
        specieService.create(specie);
        return "redirect:/specieView";
    }

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