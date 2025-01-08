package ie.atu.projectch.dummydata;

import ie.atu.projectch.entity.Address;
import ie.atu.projectch.repo.AddressRepo;
import ie.atu.projectch.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ie.atu.projectch.entity.Customer;


@Component
public class DataLoader implements CommandLineRunner {

    private final AddressRepo addressRepo;
    private final CustomerRepo customerRepo;

    @Autowired
    public DataLoader(AddressRepo addressRepo, CustomerRepo customerRepo) {
        this.addressRepo = addressRepo;
        this.customerRepo = customerRepo;
    }



    @Override
    public void run(String... args) throws Exception {

//        Customer customer1 = new Customer(null, "johndoe@gmail.com", "password123", "John", "Doe", "083 963 2441");
//        Customer customer2 = new Customer(null, "janedoe@gmail.com", "password321", "Jane", "Doe", "086 524 4587");
//        Customer customer3 = new Customer(null, "cathalhardy@gmail.com", "password213", "Cathal", "Hardy", "087 757 5846");
//
//        customerRepo.save(customer1);
//        customerRepo.save(customer2);
//        customerRepo.save(customer3);
//
//        Address address1 = new Address(null, "Garrafrauns", "Dunmore", "Tuam", "Galway", customer1);
//        Address address2 = new Address(null, "Kilconly", "Milltown", "Tuam", "Galway", customer2);
//        Address address3 = new Address(null, "Glenfield", "Rasharkin", "Ballymoney", "Antrim", customer3);
//
//        addressRepo.save(address1);
//        addressRepo.save(address2);
//        addressRepo.save(address3);

        Customer customer = new Customer();
        customer.setEmail("cathal@gmail.com");
        customer.setPassword("password123");
        customer.setFirstName("Cathal");
        customer.setLastName("Hardy");
        customer.setNumber("+353870006854");

        Address address = new Address();
        address.setAddressLine1("Garrfrauns");
        address.setAddressLine2("Dunmore");
        address.setTown("Tuam");
        address.setCounty("Galway");

        customer.setAddress(address);

// Save customer; the address will also be saved due to CascadeType.ALL
        customerRepo.save(customer);

    }
}
