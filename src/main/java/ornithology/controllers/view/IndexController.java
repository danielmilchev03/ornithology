package ornithology.controllers.view;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ornithology.data.entity.User;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String getIndex(Model model) {
        final String welcomeMessage = "Welcome to the service System!";
        model.addAttribute("welcome", welcomeMessage);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        if (user.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ADMIN"))) {
        }
        model.addAttribute("username", user.getAuthorities());

        return "index";
    }

    @GetMapping("login")
    public String login(Model model) {
        final String welcomeMessage = "Welcome to my ornithology app!";
        model.addAttribute("welcome", welcomeMessage);
        return "login";
    }

    @GetMapping("unauthorized")
    public String unauthorized(Model model) {
        final String welcomeMessage = "Welcome to my ornithology app!";
        model.addAttribute("welcome", welcomeMessage);
        return "unauthorized";
    }
}
