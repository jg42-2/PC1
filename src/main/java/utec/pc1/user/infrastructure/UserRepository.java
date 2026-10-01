package utec.pc1.user.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import utec.pc1.user.domain.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
