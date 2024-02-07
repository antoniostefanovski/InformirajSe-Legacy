package mk.awd.informirajse.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name="informirajse_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String username;
    private String name;
    private String surname;
    private String email;
    private String password;
    private LocalDate dateOfBirth;
    private String gender;
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    public User() {}

}
