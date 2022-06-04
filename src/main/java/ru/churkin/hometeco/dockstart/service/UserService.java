package ru.churkin.hometeco.dockstart.service;

import ru.churkin.hometeco.dockstart.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> getUser(Long id);

    Optional<User> getByName(String name);

    User createUser(User user);

    User updateUser(User newUser, Long id);

    Boolean deleteUser(User user);

    List<User> getAllUsers();

}
