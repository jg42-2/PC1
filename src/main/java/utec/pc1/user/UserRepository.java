package utec.pc1.user;

import org.springframework.data.jpa.repository.JpaRepository;
import utec.pc1.user.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String username);
}
