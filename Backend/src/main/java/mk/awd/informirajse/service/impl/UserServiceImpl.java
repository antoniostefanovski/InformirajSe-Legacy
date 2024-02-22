package mk.awd.informirajse.service.impl;

import mk.awd.informirajse.model.User;
import mk.awd.informirajse.model.UserRole;
import mk.awd.informirajse.model.exceptions.InvalidUsernameOrPasswordException;
import mk.awd.informirajse.model.exceptions.PasswordsDoNotMatchException;
import mk.awd.informirajse.model.exceptions.UserNotFoundException;
import mk.awd.informirajse.model.exceptions.UsernameAlreadyExistsException;
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
    public User register(String username, String password, String repeatedPassword, String email, String name, String surname, LocalDate dateOfBirth, String gender) {

        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            throw new InvalidUsernameOrPasswordException();
        }

        if (!password.equals(repeatedPassword)) {
            throw new PasswordsDoNotMatchException();
        }

        if(this.userRepository.findByUsername(username).isPresent()) {
            throw new UsernameAlreadyExistsException(username);
        }

        User user = new User(username, name, surname, email, password, dateOfBirth, gender, UserRole.ROLE_USER);

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
}
