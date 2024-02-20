package mk.awd.informirajse.web;

import mk.awd.informirajse.model.DTO.RegisterDTO;
import mk.awd.informirajse.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RegisterController {

    private final UserServiceImpl service;

    public RegisterController(UserServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/register")
    public void register(@RequestBody RegisterDTO userInfo) {
        service.register(userInfo.getUsername(),
                userInfo.getPassword(),
                userInfo.getRepeatedPassword(),
                userInfo.getEmail(),
                userInfo.getName(),
                userInfo.getSurname(),
                userInfo.getDateOfBirth(),
                userInfo.getGender()
                );
    }
}
