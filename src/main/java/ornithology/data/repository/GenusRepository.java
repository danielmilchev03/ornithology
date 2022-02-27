package ornithology.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ornithology.data.entity.Genus;

public interface GenusRepository extends JpaRepository<Genus, Integer> {
}
