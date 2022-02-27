package ornithology.service;

import org.springframework.stereotype.Service;
import ornithology.data.entity.Specie;

import java.util.List;

@Service
public interface SpecieService {
    List<Specie> getSpecie();

    Specie getSpecie(Integer id);

    Specie create(Specie specie);

    Specie updateSpecie(Specie specie, Integer id);

    void deleteSpecie(Integer id);
}
