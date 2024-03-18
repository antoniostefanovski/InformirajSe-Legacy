package mk.awd.informirajse.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @JsonBackReference
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Blog blog;
    @ManyToOne
    /**
     *   slednata linija e dodadena posle testiranje na brishenjeto komentar,
     *   zatoa shto togash zabelezhav deke e propust. ako ima nekoj problem so brishenjeto
     *   komentari najverojatno ova e problemot.
     */
    @OnDelete(action = OnDeleteAction.CASCADE)

    private User commentOwner;

    public Comment() {}

    public Comment(String commentDescription, Blog blog, User user){
        this.commentDescription = commentDescription;
        this.blog = blog;
        this.commentOwner = user;
        this.dateComment = LocalDate.now();
    }
}
