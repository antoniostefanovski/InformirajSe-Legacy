package mk.awd.informirajse.service.impl;

import mk.awd.informirajse.model.User;
import mk.awd.informirajse.model.UserRole;
import mk.awd.informirajse.model.exceptions.*;
import mk.awd.informirajse.repository.UserRepository;
import mk.awd.informirajse.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(String username, String password, String repeatedPassword, String email, String fullname, LocalDate dateOfBirth, String gender) {
        User user = new User(username, fullname, email, password, dateOfBirth, gender, UserRole.ROLE_USER);

        return this.userRepository.save(user);
    }

    @Override
    public User login(String username, String password) {
        User user = this.userRepository.findByUsername(username).orElse(null);

        if(user != null && user.getPassword().equals(password)) {
            return user;
        }

        return null;
    }

    @Override
    public User findById(Long userId) {
        return this.userRepository.findById(userId).orElse(null);
    }

    @Override
    public User findByUsername(String username) {
        return this.userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public User findByEmail(String email) {
        return this.userRepository.findByEmail(email).orElse(null);
    }
}
