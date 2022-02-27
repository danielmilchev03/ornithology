package ornithology.service.implementation;

import org.springframework.stereotype.Service;
import ornithology.data.entity.Genus;
import ornithology.data.repository.GenusRepository;
import ornithology.service.GenusService;

import java.util.List;

@Service
public class GenusImplementation implements GenusService {
    private final GenusRepository genusRepository;

    public GenusImplementation(GenusRepository genusRepository) {
        this.genusRepository = genusRepository;
    }

    public GenusRepository getGenusRepository() {
        return genusRepository;
    }

    @Override
    public List<Genus> getGenus() {
        return genusRepository.findAll();
    }

    @Override
    public Genus getGenus(Integer id) {
        return genusRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid genus id: " + id));
    }

    @Override
    public Genus create(Genus genus) {
        return genusRepository.save(genus);
    }

    @Override
    public Genus updateGenus(Genus genus, Integer id) {
        genus.setGenusId(id);

        return genusRepository.save(genus);
    }

    @Override
    public void deleteGenus(Integer id) {
        genusRepository.deleteById(id);
    }
}
