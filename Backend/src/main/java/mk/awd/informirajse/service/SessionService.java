package mk.awd.informirajse.service;

import mk.awd.informirajse.model.Session;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface SessionService {
    Session findById(UUID id);

    Session setSessionId(Long userId) throws Exception;

    void deleteById(UUID sessionId);

    void saveSession(Session session);
}
