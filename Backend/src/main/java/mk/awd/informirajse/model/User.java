package mk.awd.informirajse.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name="informirajse_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String fullname;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private LocalDate dateOfBirth;
    @Column(nullable = false)
    private String gender;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Blog> blogs;
    @OneToMany(mappedBy = "commentOwner", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Comment> comments;

    public User() {}

    public User(String username, String fullname, String email, String password, LocalDate dateOfBirth, String gender, UserRole userRole) {
        this.username = username;
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.userRole = userRole;
    }
}
