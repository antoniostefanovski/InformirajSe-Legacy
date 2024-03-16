package mk.awd.informirajse.service;


import mk.awd.informirajse.model.Comment;

import java.util.List;

public interface CommentService {

    public Comment addNewComment(String bodyContent, Long blogId, Long userId);
    public void delete(Long commentId);
}
