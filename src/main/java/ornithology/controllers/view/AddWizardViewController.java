package ornithology.controllers.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ornithology.data.entity.Genus;

import java.util.List;

@Controller
@RequestMapping("/addWizard")
public class AddWizardViewController {

    @PostMapping
    public String submit(Genus wizard, Model model) {
        model.addAttribute("wizard", wizard);
        return "saved";
    }

}
