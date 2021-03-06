package ornithology.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import ornithology.data.entity.User;

import java.util.List;

@Service
public interface UserService extends UserDetailsService {
    List<User> getUser();

    User getUser(Integer id);

    User create(User user);

    User updateUser(User user, Integer id);

    void deleteUser(Integer id);
}
