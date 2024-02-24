package mk.awd.informirajse.model.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RegisterDTO {
    String username;
    String fullname;
    String email;
    String password;
    String repeatedPassword;
    LocalDate dateOfBirth;
    String gender;
}
