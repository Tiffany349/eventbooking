package sv.udb.eventbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sv.udb.eventbooking.entity.User;

import java.util.Optional;

public interface UserRepository
        extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(
            String username
    );
}