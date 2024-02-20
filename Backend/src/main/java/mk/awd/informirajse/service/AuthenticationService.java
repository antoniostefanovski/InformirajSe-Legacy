package mk.awd.informirajse.service;

import mk.awd.informirajse.model.User;

public interface AuthenticationService {
    User login(String username, String password);
}
