package mk.awd.informirajse.service.impl;

import mk.awd.informirajse.model.User;
import mk.awd.informirajse.model.exceptions.InvalidArgumentsException;
import mk.awd.informirajse.model.exceptions.UserNotFoundException;
import mk.awd.informirajse.repository.UserRepository;
import mk.awd.informirajse.service.AuthenticationService;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;

    public AuthenticationServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        if(username == null && password == null) {
            throw new InvalidArgumentsException();
        }

        return userRepository.findByUsernameAndPassword(username, password).orElseThrow(() -> new UserNotFoundException(username));
    }
}
