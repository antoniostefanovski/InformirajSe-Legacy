package mk.awd.informirajse.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "informirajse_comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String commentDescription;
    private LocalDate dateComment;
    @ManyToOne
    private Blog blog;
    @ManyToOne
    private User commentOwner;

    public Comment() {}
}
