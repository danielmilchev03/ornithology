package ornithology.service.implementation;

import org.springframework.stereotype.Service;
import ornithology.data.entity.BirdRegion;
import ornithology.data.repository.BirdRegionRepository;
import ornithology.service.BirdRegionService;

import java.util.List;

@Service
public class BirdRegionImplementation implements BirdRegionService {
    private final BirdRegionRepository birdRegionRepository;

    public BirdRegionImplementation(BirdRegionRepository birdRegionRepository) {
        this.birdRegionRepository = birdRegionRepository;
    }

    public BirdRegionRepository getBirdRegionRepository() {
        return birdRegionRepository;
    }

    @Override
    public List<BirdRegion> getBirdRegions() {
        return birdRegionRepository.findAll();
    }

    @Override
    public BirdRegion getBirdRegion(Integer id) {
        return birdRegionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid region id: " + id));
    }

    @Override
    public BirdRegion create(BirdRegion birdRegion) {
        return birdRegionRepository.save(birdRegion);
    }

    @Override
    public BirdRegion updateBirdRegion(BirdRegion birdRegion, Integer id) {
        birdRegion.setRegionId(id);

        return birdRegionRepository.save(birdRegion);
    }

    @Override
    public void deleteBirdRegion(Integer id) {
        birdRegionRepository.deleteById(id);
    }
}
