package ie.atu.projectch.service;

import ie.atu.projectch.model.User;
import ie.atu.projectch.repo.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepo userRepo;
    public UserService(UserRepo userRepo) {this.userRepo = userRepo;}

    public void createUser(User user) {
        userRepo.save(user);
    }
}

