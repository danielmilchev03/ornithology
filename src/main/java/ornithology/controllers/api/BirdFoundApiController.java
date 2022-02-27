package ornithology.controllers.api;

import org.springframework.web.bind.annotation.*;
import ornithology.data.entity.BirdFound;
import ornithology.service.BirdFoundService;

import java.util.List;

@RestController
@RequestMapping("/api/bird_found")
public class BirdFoundApiController {

    private final BirdFoundService birdFoundService;

    public BirdFoundApiController(BirdFoundService birdFoundService) {
        this.birdFoundService = birdFoundService;
    }

    public BirdFoundService getBirdFoundService() {
        return birdFoundService;
    }

    @GetMapping
    public List<BirdFound> getBirdFound(){
        return birdFoundService.getBirdFound();
    }

    @RequestMapping("/{id}")
    public BirdFound getBirdFound(@PathVariable("id") Integer id){
        return birdFoundService.getBirdFound(id);
    }

    @PostMapping
    public BirdFound createBirdFound(@RequestBody BirdFound birdFound){
        return birdFoundService.create(birdFound);
    }

    @PutMapping(value = "/{id}")
    public BirdFound updateBirdFound(@RequestBody BirdFound birdFound, @PathVariable("id") Integer id){
        return birdFoundService.updateBirdFound(birdFound, id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteBirdFound(@PathVariable Integer id){
        birdFoundService.deleteFamily(id);
    }
}
