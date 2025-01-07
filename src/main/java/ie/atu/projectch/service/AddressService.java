package ie.atu.projectch.service;

import ie.atu.projectch.entity.Address;
import ie.atu.projectch.repo.AddressRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    private final AddressRepo addressRepo;

    public AddressService(AddressRepo addressRepo) {
        this.addressRepo = addressRepo;
    }

    public void createAddress(Address address) {
        addressRepo.save(address);
    }

    public List<Address> getAllAddresses() {
        return addressRepo.findAll();
    }

}
