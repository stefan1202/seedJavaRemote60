package ro.sda.seedjavaremote60.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.seedjavaremote60.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsernameIgnoreCase(String username);
}
