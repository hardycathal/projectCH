package ie.atu.projectch.controller;

import ie.atu.projectch.entity.Address;
import ie.atu.projectch.service.AddressService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/createAddress")
    public ResponseEntity<String> createAddress(@RequestBody Address address) {
        addressService.createAddress(address);
        return new ResponseEntity<>("Address created", HttpStatus.OK);
    }

    @GetMapping("/getAddresses")
    public ResponseEntity<?>getAddresses() {
        List<Address> addresses = addressService.getAllAddresses();
        if (addresses == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(addresses);
    }
}
