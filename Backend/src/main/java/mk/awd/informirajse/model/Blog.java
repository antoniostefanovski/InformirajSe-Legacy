package mk.awd.informirajse.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "informirajse_blogs")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String title;
    @Column(length = 300)
    private String summary;
    @Column(length = 3000)
    private String contentBody;
    private LocalDate dateCreated;
    @ManyToOne
    @JsonBackReference
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;
    @OneToMany(mappedBy = "blog", fetch = FetchType.EAGER/*, cascade = CascadeType.ALL*/)
    private List<Comment> comments;


    public Blog() {}

    public Blog(String title, String summary, String contentBody, User user){
        this.title = title;
        this.summary = summary;
        this.contentBody = contentBody;
        this.dateCreated = LocalDate.now();
        this.user = user;
    }


}
