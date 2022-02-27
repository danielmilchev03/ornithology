package ornithology.controllers.api;

import org.springframework.web.bind.annotation.*;
import ornithology.data.entity.User;
import ornithology.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserApiController {

    private final UserService userService;

    public UserApiController(UserService userService) {
        this.userService = userService;
    }

    public UserService getUserService() {
        return userService;
    }

    @GetMapping
    public List<User> getUser(){
        return userService.getUser();
    }

    @RequestMapping("/{id}")
    public User getUser(@PathVariable("id") Integer id){
        return userService.getUser(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.create(user);
    }

    @PutMapping(value = "/{id}")
    public User updateUser(@RequestBody User user, @PathVariable("id") Integer id){
        return userService.updateUser(user, id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
    }
}
