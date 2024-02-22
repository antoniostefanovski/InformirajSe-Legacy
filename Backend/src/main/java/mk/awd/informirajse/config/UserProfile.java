package mk.awd.informirajse.config;

import lombok.Data;
import mk.awd.informirajse.model.Session;
import mk.awd.informirajse.model.User;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Data
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserProfile {
    private User user = null;
    private Session session = null;
}
