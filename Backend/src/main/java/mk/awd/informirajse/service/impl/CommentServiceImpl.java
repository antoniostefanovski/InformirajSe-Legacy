package mk.awd.informirajse.service.impl;

import mk.awd.informirajse.model.Blog;
import mk.awd.informirajse.model.Comment;
import mk.awd.informirajse.model.User;
import mk.awd.informirajse.model.exceptions.BlogNotFoundException;
import mk.awd.informirajse.model.exceptions.UserIdNotFoundException;
import mk.awd.informirajse.repository.BlogRepository;
import mk.awd.informirajse.repository.CommentRepository;
import mk.awd.informirajse.repository.UserRepository;
import mk.awd.informirajse.service.CommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final BlogRepository blogRepository;
    private final UserRepository userRepository;


    public CommentServiceImpl(CommentRepository commentRepository, BlogRepository blogRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.blogRepository = blogRepository;
        this.userRepository = userRepository;
    }


    @Override
    public Comment addNewComment(String bodyContent, Long blogId, Long userId) {
        Blog blog = this.blogRepository.findById(blogId).orElseThrow(BlogNotFoundException::new);
        User user = this.userRepository.findById(userId).orElseThrow(UserIdNotFoundException::new);
        Comment comment = new Comment(bodyContent, blog, user);
        this.commentRepository.save(comment);
        return comment;
    }

    @Override
    public void delete(Long commentId) {
        this.commentRepository.deleteById(commentId);
    }
}
