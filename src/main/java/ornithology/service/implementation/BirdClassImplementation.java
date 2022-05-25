package ornithology.service.implementation;

import org.springframework.stereotype.Service;
import ornithology.data.entity.BirdClass;
import ornithology.data.repository.BirdClassRepository;
import ornithology.service.BirdClassService;

import java.util.List;

@Service
public class BirdClassImplementation implements BirdClassService {
    private final BirdClassRepository birdClassRepository;

    public BirdClassImplementation(BirdClassRepository birdClassRepository) {
        this.birdClassRepository = birdClassRepository;
    }

    public BirdClassRepository getBirdClassRepository() {
        return birdClassRepository;
    }

    @Override
    public List<BirdClass> getBirdClass() {
        return birdClassRepository.findAll();
    }

    @Override
    public BirdClass getBirdClass(Integer id) {
        return birdClassRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid class id: " + id));
    }

    @Override
    public BirdClass create(BirdClass birdClass) {
        return birdClassRepository.save(birdClass);
    }

    @Override
    public BirdClass updateBirdClass(BirdClass birdClass, Integer id) {
        birdClass.setClassId(id);

        return birdClassRepository.save(birdClass);
    }

    @Override
    public void deleteBirdClass(Integer id) {
        birdClassRepository.deleteById(id);
    }
}