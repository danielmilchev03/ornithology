package ornithology.controllers.api;

import org.springframework.web.bind.annotation.*;
import ornithology.data.entity.Classification;
import ornithology.service.ClassificationService;

import java.util.List;

@RestController
@RequestMapping("/api/classification")
public class ClassificationApiController {

    private final ClassificationService classificationService;

    public ClassificationApiController(ClassificationService classificationService) {
        this.classificationService = classificationService;
    }

    public ClassificationService getClassificationService() {
        return classificationService;
    }

    @GetMapping
    public List<Classification> getClassification(){
        return classificationService.getClassification();
    }

    @RequestMapping("/{id}")
    public Classification getClassification(@PathVariable("id") Integer id){
        return classificationService.getClassification(id);
    }

    @PostMapping
    public Classification createClassification(@RequestBody Classification classification){
        return classificationService.create(classification);
    }

    @PutMapping(value = "/{id}")
    public Classification updateClassification(@RequestBody Classification classification, @PathVariable("id") Integer id){
        return classificationService.updateClassification(classification, id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteClassification(@PathVariable Integer id){
        classificationService.deleteClassification(id);
    }
}
