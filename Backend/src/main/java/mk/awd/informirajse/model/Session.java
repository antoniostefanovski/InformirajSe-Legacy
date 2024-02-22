package mk.awd.informirajse.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "informirajse_session")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;
    @ManyToOne
    private User user;
    private LocalDateTime expireBy;

    public Session() {
        expireBy = LocalDateTime.now().plusHours(2);
    }
}
