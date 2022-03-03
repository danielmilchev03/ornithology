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

    public GenusViewController(GenusService genusService) {
        this.genusService = genusService;
    }

    @GetMapping
    public String getGenus(Model model) {
        final List<Genus> genuses = genusService.getGenus();
        model.addAttribute("genuses", genuses);
        return "/genus/genus";
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
    public String showEditGenus(Model model, @PathVariable Integer id) {
        model.addAttribute("genus", genusService.getGenus(id));
        return "/genus/edit-genus";
    }

    @PostMapping("/update/{id}")
    public String updateGenus(Model model, @PathVariable Integer id, Genus genus) {
        genusService.updateGenus(genus, id);
        return "redirect:/genusView";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable Integer id) {
        genusService.deleteGenus(id);
        return "redirect:/genusView";
    }
}