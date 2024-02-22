package mk.awd.informirajse.service.interceptors;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.awd.informirajse.config.UserProfile;
import mk.awd.informirajse.model.User;
import mk.awd.informirajse.service.SessionService;
import mk.awd.informirajse.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;


public class SessionInterceptor implements HandlerInterceptor {
    private final UserProfile userProfile;
    private final SessionService sessionService;
    private final UserService userService;

    public SessionInterceptor(UserProfile userProfile, SessionService sessionService, UserService userService) {
        this.userProfile = userProfile;
        this.sessionService = sessionService;
        this.userService = userService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        var cookies = request.getCookies();

        if (cookies == null || cookies.length == 0) {
            response.setStatus(404);
            return false;
        }

        var sessionId = Arrays.stream(cookies)
                .filter(c -> c.getName().equals("JSESSIONID"))
                .findFirst()
                .map(Cookie::getValue)
                .orElse(null);

        if(sessionId == null) {
            response.setStatus(404);
            return false;
        }

        var session = sessionService.findById(UUID.fromString(sessionId));

        if(session == null) {
            invalidateSessionCookie(response);
            response.setStatus(404);
            return false;
        }

        if(session.getExpireBy().isBefore(LocalDateTime.now())) {
            sessionService.deleteById(session.getId());
            invalidateSessionCookie(response);
            response.setStatus(404);
            return false;
        }

        var user = userService.findById(session.getUser().getId());

        if(user == null) {
            response.setStatus(404);
            return false;
        }

        userProfile.setUser(user);
        userProfile.setSession(session);
        session.setExpireBy(LocalDateTime.now().plusHours(2));
        sessionService.saveSession(session);

        return true;
    }

    private void invalidateSessionCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("JSESSIONID", null);
        cookie.setPath("/");
        cookie.setDomain("localhost");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(0);

        response.addCookie(cookie);
    }
}
