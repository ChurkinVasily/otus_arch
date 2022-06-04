package ru.churkin.hometeco.dockstart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.churkin.hometeco.dockstart.model.User;
import ru.churkin.hometeco.dockstart.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path ="/api", produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{id}")
    @ResponseBody
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id).orElse(null);
    }

    @PostMapping("/user")
    @ResponseBody
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/user/{id}")
    public User updateUser(@RequestBody User newUser, @PathVariable Long id) {
        return userService.updateUser(newUser, id);
    }

    @DeleteMapping("/user/{name}")
    public void deleteUser(@PathVariable(name = "name") String userName) {
        Optional<User> opt = userService.getByName(userName);
        userService.deleteUser(opt.orElseThrow());
    }

    @GetMapping("/user/getAll")
    @ResponseBody
    public List<User> getUsers(){
        return userService.getAllUsers();
    }


}
