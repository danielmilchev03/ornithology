package ornithology.service;

import org.springframework.stereotype.Service;
import ornithology.data.entity.Classification;

import java.util.List;

@Service
public interface ClassificationService {
    List<Classification> getClassification();

    Classification getClassification(Integer id);

    Classification create(Classification classification);

    Classification updateClassification(Classification classification, Integer id);

    void deleteClassification(Integer id);
}
