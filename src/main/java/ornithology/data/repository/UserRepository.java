package ornithology.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ornithology.data.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
