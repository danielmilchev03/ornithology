package ornithology.controllers.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ornithology.data.entity.BirdFound;
import ornithology.data.entity.User;
import ornithology.service.BirdFoundService;
import ornithology.service.SpecieService;
import ornithology.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/birdFoundView")
public class BirdFoundViewController {

    private final BirdFoundService birdFoundService;
    private final UserService userService;
    private final SpecieService specieService;

    public BirdFoundViewController(BirdFoundService birdFoundService, UserService userService, SpecieService specieService) {
        this.birdFoundService = birdFoundService;
        this.userService = userService;
        this.specieService = specieService;
    }

    @GetMapping
    public String getBirdFound(Model model) {
        final List<BirdFound> birdsFound = birdFoundService.getBirdFound();
        model.addAttribute("birdsFound", birdsFound);
        return "/birdFound/birdFound";
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
    public String showEditBirdClass(Model model, @PathVariable Integer id) {
        model.addAttribute("birdFound", birdFoundService.getBirdFound(id));
        model.addAttribute("species", specieService.getSpecie());
        return "/birdFound/edit-bird-found";
    }

    @PostMapping("/update/{id}")
    public String updateBirdFound(Model model, @PathVariable Integer id, BirdFound birdFound) {
        System.out.println("test");
        User user = userService.getUser(1);
        birdFound.setUserId(user);
        birdFoundService.updateBirdFound(birdFound, id);
        System.out.println("test 2");
        return "redirect:/birdFoundView";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable Integer id) {
        birdFoundService.deleteFamily(id);
        return "redirect:/birdFoundView";
    }
}

