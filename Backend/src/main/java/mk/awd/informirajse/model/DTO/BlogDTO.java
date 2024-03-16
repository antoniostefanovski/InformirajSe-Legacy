package mk.awd.informirajse.model.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BlogDTO {
    public String title;
    public String summary;
    public String bodyContent;
    public Long userId;
}
