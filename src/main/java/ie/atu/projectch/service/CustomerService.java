package ie.atu.projectch.service;

import ie.atu.projectch.entity.Customer;
import ie.atu.projectch.repo.CustomerRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepo customerRepo;
    public CustomerService(CustomerRepo customerRepo) {this.customerRepo = customerRepo;}

    public void register(Customer customer) {
        customerRepo.save(customer);
    }

    public Customer login(String email, String password) {
        Customer customer = customerRepo.findByEmail(email);

        if (customer != null && customer.getPassword().equals(password)) {
            return customer;
        } else {
            throw new RuntimeException("Invalid email or password");
        }
    }

    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    public Object[] getCustomerAddress(Long id){
        return customerRepo.findCustomerWithAddress(id);
    }
}

