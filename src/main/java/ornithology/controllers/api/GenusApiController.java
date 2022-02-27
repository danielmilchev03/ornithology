package ornithology.controllers.api;

import org.springframework.web.bind.annotation.*;
import ornithology.data.entity.Genus;
import ornithology.service.GenusService;

import java.util.List;

@RestController
@RequestMapping("/api/genus")
public class GenusApiController {

    private final GenusService genusService;

    public GenusApiController(GenusService genusService) {
        this.genusService = genusService;
    }

    public GenusService getGenusService() {
        return genusService;
    }

    @GetMapping
    public List<Genus> getGenus() {
        return genusService.getGenus();
    }

    @RequestMapping("/{id}")
    public Genus getGenus(@PathVariable("id") Integer id) {
        return genusService.getGenus(id);
    }

    @PostMapping
    public Genus createGenus(@RequestBody Genus genus) {
        return genusService.create(genus);
    }

    @PutMapping(value = "/{id}")
    public Genus updateGenus(@RequestBody Genus genus, @PathVariable("id") Integer id) {
        return genusService.updateGenus(genus, id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteGenus(@PathVariable Integer id) {
        genusService.deleteGenus(id);
    }
}