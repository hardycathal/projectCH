package ie.atu.projectch.dummydata;

import ie.atu.projectch.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ie.atu.projectch.entity.Customer;


@Component
public class DataLoader implements CommandLineRunner {

    private final CustomerRepo customerRepo;

    @Autowired
    public DataLoader(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        // Insert your test data here
        Customer customer1 = new Customer(null, "johndoe@gmail.com", "password123", "John", "Doe", "083 963 2441");
        Customer customer2 = new Customer(null, "janedoe@gmail.com", "password321", "Jane", "Doe", "086 524 4587");
        Customer customer3 = new Customer(null, "cathalhardy@gmail.com", "password213", "Cathal", "Hardy", "087 757 5846");

        customerRepo.save(customer1);
        customerRepo.save(customer2);
        customerRepo.save(customer3);
    }
}
