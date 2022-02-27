package ornithology.service;

import org.springframework.stereotype.Service;
import ornithology.data.entity.Family;

import java.util.List;

@Service
public interface FamilyService {
    List<Family> getFamily();

    Family getFamily(Integer id);

    Family create(Family family);

    Family updateFamily(Family family, Integer id);

    void deleteFamily(Integer id);
}
