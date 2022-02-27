package ornithology.controllers.api;

import org.springframework.web.bind.annotation.*;
import ornithology.data.entity.Specie;
import ornithology.service.SpecieService;

import java.util.List;

@RestController
@RequestMapping("/api/specie")
public class SpecieApiController {

    private final SpecieService specieService;

    public SpecieApiController(SpecieService specieService) {
        this.specieService = specieService;
    }

    public SpecieService getSpecieService() {
        return specieService;
    }

    @GetMapping
    public List<Specie> getSpecie(){
        return specieService.getSpecie();
    }

    @RequestMapping("/{id}")
    public Specie getSpecie(@PathVariable("id") Integer id){
        return specieService.getSpecie(id);
    }

    @PostMapping
    public Specie createSpecie(@RequestBody Specie specie){
        return specieService.create(specie);
    }

    @PutMapping(value = "/{id}")
    public Specie updateSpecie(@RequestBody Specie specie, @PathVariable("id") Integer id){
        return specieService.updateSpecie(specie, id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteSpecie(@PathVariable Integer id){
        specieService.deleteSpecie(id);
    }
}
