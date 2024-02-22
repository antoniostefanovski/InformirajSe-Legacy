package mk.awd.informirajse.service.impl;

import mk.awd.informirajse.model.User;
import mk.awd.informirajse.model.exceptions.InvalidArgumentsException;
import mk.awd.informirajse.model.exceptions.UserNotFoundException;
import mk.awd.informirajse.repository.UserRepository;
import mk.awd.informirajse.service.AuthenticationService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;

    public AuthenticationServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        if(username == null || password == null) {
            throw new InvalidArgumentsException();
        }

        Optional<User> userExists = userRepository.findByUsername(username);

        if(userExists.isEmpty()) {
            return null;
        }

        return userRepository.findByUsernameAndPassword(username, password).orElseThrow(() -> new UserNotFoundException(username));
    }
}
