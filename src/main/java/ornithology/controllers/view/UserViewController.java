package ornithology.controllers.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ornithology.data.entity.*;
import ornithology.service.*;

import java.util.List;

@Controller
@RequestMapping("/userView")
public class UserViewController {

    private final UserService userService;

    public UserViewController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getUser(Model model) {
        final List<User> users = userService.getUser();
        model.addAttribute("users", users);
        return "/user/user";
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
    public String showEditUser(Model model, @PathVariable Integer id) {
        model.addAttribute("user", userService.getUser(id));
        return "/user/edit-user";
    }

    @PostMapping("/update/{id}")
    public String updateUser(Model model, @PathVariable Integer id, User user) {
        userService.updateUser(user, id);
        return "redirect:/userView";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable Integer id) {
        userService.deleteUser(id);
        return "redirect:/userView";
    }
}