package ornithology.controllers.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ornithology.data.entity.BirdClass;
import ornithology.data.entity.BirdFound;
import ornithology.data.entity.BirdRegion;
import ornithology.service.BirdClassService;
import ornithology.service.BirdFoundService;
import ornithology.service.BirdRegionService;

import java.util.List;

@Controller
@RequestMapping("/birdRegionView")
public class BirdRegionViewController {

    private final BirdRegionService birdRegionService;

    public BirdRegionViewController(BirdRegionService birdRegionService) {
        this.birdRegionService = birdRegionService;
    }

    @GetMapping
    public String getBirdRegion(Model model) {
        final List<BirdRegion> birdRegions = birdRegionService.getBirdRegion();
        model.addAttribute("birdRegions", birdRegions);
        return "/birdRegion/birdRegion";
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
    public String showEditBirdRegion(Model model, @PathVariable Integer id) {
        model.addAttribute("birdRegion", birdRegionService.getBirdRegion(id));
        return "/birdRegion/edit-bird-region";
    }

    @PostMapping("/update/{id}")
    public String updateBirdRegion(Model model, @PathVariable Integer id, BirdRegion birdRegion) {
        birdRegionService.updateBirdRegion(birdRegion, id);
        return "redirect:/birdRegionView";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable Integer id) {
        birdRegionService.deleteBirdRegion(id);
        return "redirect:/birdRegionView";
    }
}

