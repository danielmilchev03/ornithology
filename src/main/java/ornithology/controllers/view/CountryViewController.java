package ornithology.controllers.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ornithology.data.entity.BirdClass;
import ornithology.data.entity.BirdFound;
import ornithology.data.entity.BirdRegion;
import ornithology.data.entity.Country;
import ornithology.service.BirdClassService;
import ornithology.service.BirdFoundService;
import ornithology.service.BirdRegionService;
import ornithology.service.CountryService;

import java.util.List;

@Controller
@RequestMapping("/countryView")
public class CountryViewController {

    private final CountryService countryService;

    public CountryViewController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public String getCountry(Model model) {
        final List<Country> countries = countryService.getCountry();
        model.addAttribute("countries", countries);
        return "/country/country";
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
    public String showEditCountry(Model model, @PathVariable Integer id) {
        model.addAttribute("country", countryService.getCountry(id));
        return "/country/edit-country";
    }

    @PostMapping("/update/{id}")
    public String updateCountry(Model model, @PathVariable Integer id, Country country) {
        countryService.updateCountry(country, id);
        return "redirect:/countryView";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable Integer id) {
        countryService.deleteCountry(id);
        return "redirect:/countryView";
    }
}

