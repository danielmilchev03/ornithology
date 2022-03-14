package ornithology.service.implementation;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ornithology.data.entity.Family;
import ornithology.data.entity.User;
import ornithology.data.repository.UserRepository;
import ornithology.service.UserService;

import java.util.List;

@Service
public class UserImplementation implements UserService {
    private final UserRepository userRepository;

    public UserImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    @Override
    public List<User> getUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user id: " + id));
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user, Integer id) {
        user.setUserId(id);

        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(userName);
        if (user == null) {
            throw new UsernameNotFoundException(userName);
        }
        return (UserDetails) user;
    }

}
