package mk.awd.informirajse.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "informirajse_blogs")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String title;
    private String contentBody;
    private LocalDate dateCreated;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "blog", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Comment> comments;

    public Blog() {}
}
