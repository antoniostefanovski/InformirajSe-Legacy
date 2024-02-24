package mk.awd.informirajse.web;

import mk.awd.informirajse.model.DTO.RegisterDTO;
import mk.awd.informirajse.model.Registration;
import mk.awd.informirajse.model.User;
import mk.awd.informirajse.model.enums.RegisterError;
import mk.awd.informirajse.service.UserService;
import mk.awd.informirajse.service.impl.UserServiceImpl;
import mk.awd.informirajse.service.validators.RegistrationValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class RegisterController {

    private final UserService service;

    public RegisterController(UserServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<Registration> register(@RequestBody RegisterDTO userInfo) {
        var model = new Registration();

        if(!RegistrationValidator.isValidForSubmit(userInfo)) {
            model.setErrorType(RegisterError.InvalidModel);
            return ResponseEntity.ok(model);
        }

        // validate model (userInfo) in a separate static class validator
        // if not valid -- return custom api response class
        // api response class will include: List<ErrorType enum>, ok boolean, response object!

        var userExists = service.findByUsername(userInfo.getUsername());

        if(userExists != null) {
            model.setErrorType(RegisterError.UserExists);
            return ResponseEntity.ok(model);
        }

        service.register(userInfo.getUsername(),
                userInfo.getPassword(),
                userInfo.getRepeatedPassword(),
                userInfo.getEmail(),
                userInfo.getFullname(),
                userInfo.getDateOfBirth(),
                userInfo.getGender()
                );

        model.setOk(true);

        return ResponseEntity.ok(model);
    }
}
