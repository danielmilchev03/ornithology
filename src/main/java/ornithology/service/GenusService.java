package ornithology.service;

import org.springframework.stereotype.Service;
import ornithology.data.entity.Genus;

import java.util.List;

@Service
public interface GenusService {
    List<Genus> getGenus();

    Genus getGenus(Integer id);

    Genus create(Genus genus);

    Genus updateGenus(Genus genus, Integer id);

    void deleteGenus(Integer id);
}
