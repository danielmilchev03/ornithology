package ornithology.service;

import org.springframework.stereotype.Service;
import ornithology.data.entity.BirdRegion;

import java.util.List;

@Service
public interface BirdRegionService {
    List<BirdRegion> getBirdRegions();

    BirdRegion getBirdRegion(Integer id);

    BirdRegion create(BirdRegion birdRegion);

    BirdRegion updateBirdRegion(BirdRegion birdRegion, Integer id);

    void deleteBirdRegion(Integer id);
}
