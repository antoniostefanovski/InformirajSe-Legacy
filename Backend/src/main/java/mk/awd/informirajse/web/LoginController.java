package mk.awd.informirajse.web;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mk.awd.informirajse.config.UserProfile;
import mk.awd.informirajse.model.DTO.LoginDTO;
import mk.awd.informirajse.model.Session;
import mk.awd.informirajse.model.User;
import mk.awd.informirajse.service.SessionService;
import mk.awd.informirajse.service.UserService;
import mk.awd.informirajse.service.impl.AuthenticationServiceImpl;
import mk.awd.informirajse.service.impl.SessionServiceImpl;
import mk.awd.informirajse.service.impl.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping("/api")
public class LoginController {

    private final UserService userService;
    private final SessionService sessionService;
    private final UserProfile userProfile;

    public LoginController(UserService userService, SessionService sessionService, UserProfile userProfile) {
        this.userService = userService;
        this.sessionService = sessionService;
        this.userProfile = userProfile;
    }

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody LoginDTO userInfo, HttpServletRequest request, HttpServletResponse response) {
        User authenticatedUser = this.userService.login(userInfo.getUsername(), userInfo.getPassword());

        if(authenticatedUser == null) {
            return ResponseEntity.notFound().build();
        }

        Session session = null;

       try {
           session = sessionService.setSessionId(authenticatedUser.getId());
       }
       catch (Exception e) {
           return ResponseEntity.internalServerError().build();
       }

       if(session == null) {
           return ResponseEntity.internalServerError().build();
       }

        Cookie cookie = new Cookie("JSESSIONID", session.getId().toString());
        cookie.setPath("/");
        cookie.setDomain("localhost");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(3600);

        response.addCookie(cookie);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/isAuthenticated")
    public ResponseEntity<Void> isAuthenticated(HttpServletRequest request) {
        var user = userProfile.getUser();

        if (user == null) {
           return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().build();
    }

    @GetMapping("/log-out")
    public ResponseEntity<Void> logOut(HttpServletResponse response) {

        var session = userProfile.getSession();

        if (session == null) {
            return ResponseEntity.notFound().build();
        }

        sessionService.deleteById(session.getId());

        Cookie cookie = new Cookie("JSESSIONID", null);
        cookie.setPath("/");
        cookie.setDomain("localhost");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(0);

        response.addCookie(cookie);

        return ResponseEntity.ok().build();
    }
}
