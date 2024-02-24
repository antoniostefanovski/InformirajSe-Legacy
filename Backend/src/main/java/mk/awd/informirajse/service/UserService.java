package mk.awd.informirajse.service;

import mk.awd.informirajse.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

public interface UserService {
    User register(String username, String password, String repeatedPassword, String email, String fullname, LocalDate dateOfBirth, String gender);
    User login(String username, String password);
    User findById(Long userId);
    User findByUsername(String username);
    User findByEmail(String email);
}
