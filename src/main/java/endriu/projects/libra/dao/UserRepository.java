package endriu.projects.libra.dao;

import endriu.projects.libra.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserName(String userName);

    boolean existsByUserName(String username);

    User getByUserName(String username);

    User getById(int id);
}