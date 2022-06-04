package ru.churkin.hometeco.dockstart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.churkin.hometeco.dockstart.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> getByUserName(String userName);
}
