package ornithology.service;

import ornithology.data.entity.BirdClass;

import java.util.List;

public interface BirdClassService {
    List<BirdClass> getBirdClass();

    BirdClass getBirdClass(Integer id);

    BirdClass create(BirdClass birdClass);

    BirdClass updateBirdClass(BirdClass birdClass, Integer id);

    void deleteBirdClass(Integer id);
}
