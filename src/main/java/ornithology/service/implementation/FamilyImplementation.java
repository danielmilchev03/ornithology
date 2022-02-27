package ornithology.service.implementation;

import org.springframework.stereotype.Service;
import ornithology.data.entity.Family;
import ornithology.data.repository.FamilyRepository;
import ornithology.service.FamilyService;

import java.util.List;

@Service
public class FamilyImplementation implements FamilyService {
    private final FamilyRepository familyRepository;

    public FamilyImplementation(FamilyRepository familyRepository) {
        this.familyRepository = familyRepository;
    }

    public FamilyRepository getFamilyRepository() {
        return familyRepository;
    }

    @Override
    public List<Family> getFamily() {
        return familyRepository.findAll();
    }

    @Override
    public Family getFamily(Integer id) {
        return familyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid family id: " + id));
    }

    @Override
    public Family create(Family family) {
        return familyRepository.save(family);
    }

    @Override
    public Family updateFamily(Family family, Integer id) {
        family.setFamilyId(id);

        return familyRepository.save(family);
    }

    @Override
    public void deleteFamily(Integer id) {
        familyRepository.deleteById(id);
    }
}
