package ornithology.controllers.api;

import org.springframework.web.bind.annotation.*;
import ornithology.data.entity.Family;
import ornithology.service.FamilyService;

import java.util.List;

@RestController
@RequestMapping("/api/family")
public class FamilyApiController {

    private final FamilyService familyService;

    public FamilyApiController(FamilyService familyService) {
        this.familyService = familyService;
    }

    public FamilyService getFamilyService() {
        return familyService;
    }

    @GetMapping
    public List<Family> getFamily(){
        return familyService.getFamily();
    }

    @RequestMapping("/{id}")
    public Family getFamily(@PathVariable("id") Integer id){
        return familyService.getFamily(id);
    }

    @PostMapping
    public Family createFamily(@RequestBody Family family){
        return familyService.create(family);
    }

    @PutMapping(value = "/{id}")
    public Family updateFamily(@RequestBody Family family, @PathVariable("id") Integer id){
        return familyService.updateFamily(family, id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteFamily(@PathVariable Integer id){
        familyService.deleteFamily(id);
    }
}