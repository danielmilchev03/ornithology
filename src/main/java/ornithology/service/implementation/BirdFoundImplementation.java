package ornithology.service.implementation;

import org.springframework.stereotype.Service;
import ornithology.data.entity.BirdFound;
import ornithology.data.repository.BirdFoundRepository;
import ornithology.service.BirdFoundService;

import java.util.List;

@Service
public class BirdFoundImplementation implements BirdFoundService {
    private final BirdFoundRepository birdFoundRepository;

    public BirdFoundImplementation(BirdFoundRepository birdFoundRepository) {
        this.birdFoundRepository = birdFoundRepository;
    }

    public BirdFoundRepository getBirdFoundRepository() {
        return birdFoundRepository;
    }


    @Override
    public List<BirdFound> getBirdFound() {
        return birdFoundRepository.findAll();
    }

    @Override
    public BirdFound getBirdFound(Integer id) {
        return birdFoundRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid bird_found id" + id));
    }

    @Override
    public BirdFound create(BirdFound birdFound) {
        return birdFoundRepository.save(birdFound);
    }

    @Override
    public BirdFound updateBirdFound(BirdFound birdFound, Integer id) {
        birdFound.setBirdFoundId(id);

        return birdFoundRepository.save(birdFound);
    }

    @Override
    public void deleteFamily(Integer id) {
        birdFoundRepository.deleteById(id);
    }
}
