package mk.awd.informirajse.model;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {
    ROLE_ADMIN, ROLE_EDITOR, ROLE_USER;

    @Override
    public String getAuthority() {
        return name();
    }
}
