package ie.atu.projectch.service;

import ie.atu.projectch.dto.Menu;
import ie.atu.projectch.entity.Address;
import ie.atu.projectch.entity.Customer;
import ie.atu.projectch.feign.MenuClient;
import ie.atu.projectch.repo.AddressRepo;
import ie.atu.projectch.repo.CustomerRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepo customerRepo;
    private final AddressRepo addressRepo;
    private final MenuClient menuClient;

    public CustomerService(CustomerRepo customerRepo, AddressRepo addressRepo, MenuClient menuClient) {this.customerRepo = customerRepo;
        this.addressRepo = addressRepo;
        this.menuClient = menuClient;
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

    public List<Menu> showItems() {
        ResponseEntity<List<ie.atu.projectch.dto.Menu>> response = menuClient.showItems();
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            throw new RuntimeException("Failed to fetch menu items");
        }
    }

    public Customer getCustomerById(Long id) {
        return customerRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer with ID " + id + " not found"));
    }

}

