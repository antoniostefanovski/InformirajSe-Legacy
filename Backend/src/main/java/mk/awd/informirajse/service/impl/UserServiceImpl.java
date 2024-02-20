package mk.awd.informirajse.service.impl;

import mk.awd.informirajse.model.User;
import mk.awd.informirajse.model.UserRole;
import mk.awd.informirajse.model.exceptions.InvalidUsernameOrPasswordException;
import mk.awd.informirajse.model.exceptions.PasswordsDoNotMatchException;
import mk.awd.informirajse.model.exceptions.UserNotFoundException;
import mk.awd.informirajse.model.exceptions.UsernameAlreadyExistsException;
import mk.awd.informirajse.repository.UserRepository;
import mk.awd.informirajse.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
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

        User user = new User(username, name, surname, email, passwordEncoder.encode(password), dateOfBirth, gender, UserRole.ROLE_USER);

        return this.userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException(username));

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                Collections.singleton(user.getUserRole())
        );
    }
}
