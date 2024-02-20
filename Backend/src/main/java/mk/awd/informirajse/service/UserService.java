package mk.awd.informirajse.service;

import mk.awd.informirajse.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.time.LocalDate;

public interface UserService extends UserDetailsService {
    User register(String username, String password, String repeatedPassword, String email, String name, String surname, LocalDate dateOfBirth, String gender);
}
