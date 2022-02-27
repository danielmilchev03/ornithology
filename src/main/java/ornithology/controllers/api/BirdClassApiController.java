package ornithology.controllers.api;

import org.springframework.web.bind.annotation.*;
import ornithology.data.entity.BirdClass;
import ornithology.service.BirdClassService;

import java.util.List;

@RestController
@RequestMapping("/api/class")
public class BirdClassApiController {

    private final BirdClassService birdClassService;

    public BirdClassApiController(BirdClassService birdClassService) {
        this.birdClassService = birdClassService;
    }

    public BirdClassService getBirdClassService() {
        return birdClassService;
    }

    @GetMapping
    public List<BirdClass> getBirdClass(){
        return birdClassService.getBirdClass();
    }

    @RequestMapping("/{id}")
    public BirdClass getBirdClass(@PathVariable("id") Integer id){
        return birdClassService.getBirdClass(id);
    }

    @PostMapping
    public BirdClass create(@RequestBody BirdClass birdClass){
        return birdClassService.create(birdClass);
    }

    @PutMapping(value = "/{id}")
    public BirdClass updateBirdClass(@RequestBody BirdClass birdClass, @PathVariable("id") Integer id){
        return birdClassService.updateBirdClass(birdClass, id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteFamily(@PathVariable Integer id){
        birdClassService.deleteBirdClass(id);
    }
}