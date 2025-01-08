package ie.atu.projectch.repo;

import ie.atu.projectch.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
    @Query(value = "SELECT " +
            "c.id AS customer_id, " +
            "c.email, " +
            "c.password, " +
            "c.first_name, " +
            "c.last_name, " +
            "c.number, " +
            "a.id AS address_id, " +
            "a.address_line1, " +
            "a.address_line2, " +
            "a.town, " +
            "a.county " +
            "FROM customer c " +
            "JOIN address a ON c.address_id = a.id " +
            "WHERE c.id = :customerId",
            nativeQuery = true)
    Object[] findCustomerWithAddress(@Param("customerId") Long customerId);

    Customer findByEmail(String email);


}
