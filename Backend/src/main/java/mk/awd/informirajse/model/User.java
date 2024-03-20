package mk.awd.informirajse.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER/*, cascade = CascadeType.ALL*/)
    @JsonManagedReference
    private List<Blog> blogs;
    @OneToMany(mappedBy = "commentOwner", fetch = FetchType.EAGER/*, cascade = CascadeType.ALL*/)
    @JsonManagedReference
    private List<Comment> comments;


    public User() {}

    public User(String username, String name, String surname, String email, String password, LocalDate dateOfBirth, String gender, UserRole userRole) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.userRole = userRole;

    }
}
