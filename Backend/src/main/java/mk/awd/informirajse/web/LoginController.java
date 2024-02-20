package mk.awd.informirajse.web;

import jakarta.servlet.http.HttpSession;
import mk.awd.informirajse.model.DTO.LoginDTO;
import mk.awd.informirajse.model.User;
import mk.awd.informirajse.service.impl.AuthenticationServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginController {

    private final AuthenticationServiceImpl service;

    public LoginController(AuthenticationServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody LoginDTO userInfo, HttpSession session) {
        User authenticatedUser = this.service.login(userInfo.getUsername(), userInfo.getPassword());

        if(authenticatedUser != null) {
            session.setAttribute(authenticatedUser.getUsername(), authenticatedUser.getUsername());
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}
