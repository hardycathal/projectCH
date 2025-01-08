package ie.atu.projectch.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Email(message = "Incorrect format")
    @NotBlank(message = "Email cannot be blank")
    private String email;
    @NotBlank(message = "Password cannot be blank")
    @Size(min = 6, max = 15, message = "Password must be between 6 and 15 characters")
    private String password;
    @NotBlank(message = "Name cannot be blank")
    private String firstName;
    @NotBlank(message = "Name cannot be blank")
    private String lastName;
    @NotBlank(message="Number cannot be blank")
    @Pattern(regexp = "^\\+353\\s?[0-9]{9}$", message = "Number must begin with '+353' and 9 numbers thereafter")
    private String number;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    public Customer() {
    }

    public Customer(Long id, String email, String password, String firstName, String lastName, String number) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNumber() {
        return number;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    public void setAddress(Address address) {
        this.address = address;
    }
}
