package ru.churkin.hometeco.dockstart.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.churkin.hometeco.dockstart.model.User;
import ru.churkin.hometeco.dockstart.repository.UserRepository;
import ru.churkin.hometeco.dockstart.service.UserService;

import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    //
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> getUser(Long id) {
//        return Optional.of(new User());
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> getByName(String name) {
        return userRepository.getByUserName(name);
    }

    //
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    //
    @Override
    public User updateUser(User newUser, Long id) {
        User byId = userRepository.getById(id);
        if (byId == null) {
            byId = new User();
        }
        byId.setUserName(newUser.getUserName());
        byId.setFirstName(newUser.getFirstName());
        byId.setLastName(newUser.getLastName());
        byId.setPhone(newUser.getPhone());
        byId.setEmail(newUser.getEmail());
        return userRepository.save(byId);
    }

    @Override
    public Boolean deleteUser(User user) {
        try {
            userRepository.delete(user);
            return Boolean.TRUE;
        } catch (Exception e) {
//            log.error("Error during delete");
            return Boolean.FALSE;
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
