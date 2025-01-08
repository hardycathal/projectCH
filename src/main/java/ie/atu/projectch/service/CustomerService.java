package ie.atu.projectch.service;

import ie.atu.projectch.entity.Address;
import ie.atu.projectch.entity.Customer;
import ie.atu.projectch.repo.AddressRepo;
import ie.atu.projectch.repo.CustomerRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepo customerRepo;
    private final AddressRepo addressRepo;

    public CustomerService(CustomerRepo customerRepo, AddressRepo addressRepo) {this.customerRepo = customerRepo;
        this.addressRepo = addressRepo;
    }

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

    public Customer assignAddress(Long id, Address address) {
        Customer customer = customerRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Address savedAddress = addressRepo.save(address);

        customer.setAddress(savedAddress);

        return customerRepo.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    public Object[] getCustomerAddress(Long id){
        return customerRepo.findCustomerWithAddress(id);
    }
}

