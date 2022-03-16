package ornithology.config;/*

import car_service.data.entity.User;
import car_service.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DbInit implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    public DbInit() {}

    public DbInit(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("1234");
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setEnabled(true);
        user.setCredentialsNonExpired(true);

        User user2 = new User();
        user2.setUsername("admin_auto_service");
        user2.setPassword("1234");
        user2.setAccountNonExpired(true);
        user2.setAccountNonLocked(true);
        user2.setEnabled(true);
        user2.setCredentialsNonExpired(true);

        List<User> users = Arrays.asList(user, user2);

        // Save to db
        this.userRepository.saveAll(users);
    }
}*/
