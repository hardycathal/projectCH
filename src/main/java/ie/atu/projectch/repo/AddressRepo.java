package ie.atu.projectch.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ie.atu.projectch.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Long> {
}
