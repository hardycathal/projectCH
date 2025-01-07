package ie.atu.projectch.controller;

import ie.atu.projectch.model.User;
import ie.atu.projectch.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(@RequestBody User user){
        userService.createUser(user);
        return new ResponseEntity<>("User Created Successfully", HttpStatus.OK);
    }

}
