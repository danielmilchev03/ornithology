package ornithology.service.implementation;

import org.springframework.stereotype.Service;
import ornithology.data.entity.Classification;
import ornithology.data.entity.Family;
import ornithology.data.repository.ClassificationRepository;
import ornithology.service.ClassificationService;

import java.util.List;

@Service
public class ClassificationImplementation implements ClassificationService {
    private final ClassificationRepository classificationRepository;

    public ClassificationImplementation(ClassificationRepository classificationRepository) {
        this.classificationRepository = classificationRepository;
    }

    public ClassificationRepository getClassificationRepository() {
        return classificationRepository;
    }

    @Override
    public List<Classification> getClassification() {
        return classificationRepository.findAll();
    }

    @Override
    public Classification getClassification(Integer id) {
        return classificationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid classification id: " + id));
    }

    @Override
    public Classification create(Classification classification) {
        return classificationRepository.save(classification);
    }

    @Override
    public Classification updateClassification(Classification classification, Integer id) {
        classification.setClassificationId(id);

        return classificationRepository.save(classification);
    }

    @Override
    public void deleteClassification(Integer id) {
        classificationRepository.deleteById(id);
    }
}
