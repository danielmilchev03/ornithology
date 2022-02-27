package ornithology.service;

import org.springframework.stereotype.Service;
import ornithology.data.entity.BirdFound;

import java.util.List;

@Service
public interface BirdFoundService {
    List<BirdFound> getBirdFound();

    BirdFound getBirdFound(Integer id);

    BirdFound create(BirdFound birdFound);

    BirdFound updateBirdFound(BirdFound birdFound, Integer id);

    void deleteFamily(Integer id);
}
