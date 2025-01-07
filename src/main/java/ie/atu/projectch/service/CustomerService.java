package ie.atu.projectch.service;

import ie.atu.projectch.model.Customer;
import ie.atu.projectch.repo.CustomerRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepo customerRepo;
    public CustomerService(CustomerRepo customerRepo) {this.customerRepo = customerRepo;}

    public void createCustomer(Customer customer) {
        customerRepo.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }
}

