package mk.awd.informirajse.model.DTO;

import lombok.Data;

@Data
public class CommentDTO {
    public String commentDescription;
    public Long blogId;
    public Long userId;
}
