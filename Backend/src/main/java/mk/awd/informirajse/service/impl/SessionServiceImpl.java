package mk.awd.informirajse.service.impl;

import mk.awd.informirajse.model.Session;
import mk.awd.informirajse.model.exceptions.UserNotFoundException;
import mk.awd.informirajse.repository.SessionRepository;
import mk.awd.informirajse.repository.UserRepository;
import mk.awd.informirajse.service.SessionService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SessionServiceImpl implements SessionService {

    private final SessionRepository sessionRepository;
    private final UserRepository userRepository;

    public SessionServiceImpl(SessionRepository sessionRepository, UserRepository userRepository) {
        this.sessionRepository = sessionRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Session findById(UUID id) {
        return this.sessionRepository.findById(id).orElse(null);
    }

    @Override
    public Session setSessionId(Long userId) throws Exception {
        var session = new Session();
        var user = this.userRepository.findById(userId).orElseThrow(Exception::new);
        session.setUser(user);
        return this.sessionRepository.save(session);
    }

    @Override
    public void deleteById(UUID sessionId) {
        sessionRepository.deleteById(sessionId);
    }

    @Override
    public void saveSession(Session session) {
        sessionRepository.save(session);
    }
}
