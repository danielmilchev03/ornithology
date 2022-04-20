package ornithology.controllers.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ornithology.data.entity.BirdClass;
import ornithology.data.entity.User;
import ornithology.service.BirdClassService;
import ornithology.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/birdClassView")
public class BirdClassViewController {

    private final BirdClassService birdClassService;
    private final UserService userService;

    public BirdClassViewController(BirdClassService birdClassService, UserService userService) {
        this.birdClassService = birdClassService;
        this.userService = userService;
    }


    @GetMapping
    public String getBirdClass(Model model) {
        final List<BirdClass> birdClasses = birdClassService.getBirdClass();
        model.addAttribute("birdClasses", birdClasses);
        return "/birdClass/birdClass";
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
        model.addAttribute("birdClass", birdClassService.getBirdClass(id));
        return "/birdClass/edit-bird-class";
    }

    @PostMapping("/update/{id}")
    public String updateBirdClass(Model model, @PathVariable Integer id, BirdClass birdClass) {
        User user = userService.getUser(1);
        System.out.println("user: " + user + ", instance: " + this);
        birdClass.setUserId(user);
        birdClassService.updateBirdClass(birdClass, id);
        return "redirect:/birdClassView";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable Integer id) {
        birdClassService.deleteBirdClass(id);
        return "redirect:/birdClassView";
    }
}

