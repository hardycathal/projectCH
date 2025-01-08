package ie.atu.projectch.controller;

import ie.atu.projectch.entity.Address;
import ie.atu.projectch.entity.Customer;
import ie.atu.projectch.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @PostMapping("/createCustomer")
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer){
        customerService.createCustomer(customer);
        return new ResponseEntity<>("User Created Successfully", HttpStatus.OK);
    }

    @GetMapping("/showCustomers")
    public ResponseEntity<?> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();

        if (customers == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customers);
    }
    @GetMapping("/getAddress/{id}")
    public ResponseEntity<?> getCustomerAddress(@PathVariable Long id){
        Object[] customer = customerService.getCustomerAddress(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

}
