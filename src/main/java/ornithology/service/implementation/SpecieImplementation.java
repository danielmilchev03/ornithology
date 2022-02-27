package ornithology.service.implementation;

import org.springframework.stereotype.Service;
import ornithology.data.entity.Specie;
import ornithology.data.repository.SpecieRepository;
import ornithology.service.SpecieService;

import java.util.List;

@Service
public class SpecieImplementation implements SpecieService {
    private final SpecieRepository specieRepository;

    public SpecieImplementation(SpecieRepository specieRepository) {
        this.specieRepository = specieRepository;
    }

    public SpecieRepository getSpecieRepository() {
        return specieRepository;
    }

    @Override
    public List<Specie> getSpecie() {
        return specieRepository.findAll();
    }

    @Override
    public Specie getSpecie(Integer id) {
        return specieRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid specie id: " + id));
    }

    @Override
    public Specie create(Specie specie) {
        return specieRepository.save(specie);
    }

    @Override
    public Specie updateSpecie(Specie specie, Integer id) {
        specie.setSpeciesId(id);

        return specieRepository.save(specie);
    }

    @Override
    public void deleteSpecie(Integer id) {
        specieRepository.deleteById(id);
    }
}
