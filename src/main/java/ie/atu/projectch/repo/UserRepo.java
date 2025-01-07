package ie.atu.projectch.repo;

import ie.atu.projectch.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
