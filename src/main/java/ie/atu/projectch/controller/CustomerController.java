package ie.atu.projectch.controller;

import ie.atu.projectch.dto.LoginDTO;
import ie.atu.projectch.dto.Menu;
import ie.atu.projectch.entity.Address;
import ie.atu.projectch.entity.Customer;
import ie.atu.projectch.feign.MenuClient;
import ie.atu.projectch.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;
    private final MenuClient menuClient;

    public CustomerController(CustomerService customerService, MenuClient menuClient){
        this.customerService = customerService;
        this.menuClient = menuClient;
    }


    //Register
    @PostMapping("/register")
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer){
        customerService.register(customer);
        return new ResponseEntity<>("User Created Successfully", HttpStatus.OK);
    }

    //Login
    @PostMapping("/login")
    public ResponseEntity<Customer> login(@RequestBody LoginDTO loginDTO){
        Customer customer = customerService.login(loginDTO.getEmail(), loginDTO.getPassword());
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    //Save address
    @PostMapping("/{id}/address")
    public ResponseEntity<Customer> assignAddress(@PathVariable Long id, @RequestBody Address address){
        Customer customerAddress = customerService.assignAddress(id, address);
        return new ResponseEntity<>(customerAddress, HttpStatus.OK);
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

    @GetMapping("/items")
    public ResponseEntity<List<Menu>> showItems() {
        return new ResponseEntity<>(customerService.showItems(), HttpStatus.OK);
    }

}
