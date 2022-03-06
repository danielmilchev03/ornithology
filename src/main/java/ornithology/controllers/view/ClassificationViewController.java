package ornithology.controllers.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ornithology.data.entity.BirdClass;
import ornithology.data.entity.Classification;
import ornithology.data.entity.User;
import ornithology.service.BirdClassService;
import ornithology.service.ClassificationService;
import ornithology.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/classificationView")
public class ClassificationViewController {

    private final ClassificationService classificationService;
    private final UserService userService;

    public ClassificationViewController(ClassificationService classificationService, UserService userService) {
        this.classificationService = classificationService;
        this.userService = userService;
    }

    @GetMapping
    public String getClassification(Model model) {
        final List<Classification> classifications = classificationService.getClassification();
        model.addAttribute("classifications", classifications);
        return "/classification/classification";
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
    public String showEditClassification(Model model, @PathVariable Integer id) {
        model.addAttribute("classification", classificationService.getClassification(id));
        return "/classification/edit-classification";
    }

    @PostMapping("/update/{id}")
    public String updateClassification(Model model, @PathVariable Integer id, Classification classification) {
        User user = userService.getUser(1);
        classification.setUserId(user);
        classificationService.updateClassification(classification, id);
        return "redirect:/classificationView";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable Integer id) {
        classificationService.deleteClassification(id);
        return "redirect:/classificationView";
    }
}

