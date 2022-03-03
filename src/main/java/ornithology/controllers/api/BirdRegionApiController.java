package ornithology.controllers.api;

import org.springframework.web.bind.annotation.*;
import ornithology.data.entity.BirdRegion;
import ornithology.service.BirdRegionService;

import java.util.List;

@RestController
@RequestMapping("/api/bird_region")
public class BirdRegionApiController {

    private final BirdRegionService birdRegionService;

    public BirdRegionApiController(BirdRegionService birdRegionService) {
        this.birdRegionService = birdRegionService;
    }

    public BirdRegionService getBirdRegionService() {
        return birdRegionService;
    }

    @GetMapping
    public List<BirdRegion> getBirdRegion(){
        return birdRegionService.getBirdRegion();
    }

    @RequestMapping("/{id}")
    public BirdRegion getBirdRegion(@PathVariable("id") Integer id){
        return birdRegionService.getBirdRegion(id);
    }

    @PostMapping
    public BirdRegion createBirdRegion(@RequestBody BirdRegion birdRegion){
        return birdRegionService.create(birdRegion);
    }

    @PutMapping(value = "/{id}")
    public BirdRegion updateBirdRegion(@RequestBody BirdRegion birdRegion, @PathVariable("id") Integer id){
        return birdRegionService.updateBirdRegion(birdRegion, id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteBirdRegion(@PathVariable Integer id){
        birdRegionService.deleteBirdRegion(id);
    }
}