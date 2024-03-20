package mk.awd.informirajse.service.impl;


import mk.awd.informirajse.config.UserProfile;
import mk.awd.informirajse.model.Blog;
import mk.awd.informirajse.model.Comment;
import mk.awd.informirajse.model.User;
import mk.awd.informirajse.model.exceptions.BlogNotFoundException;
import mk.awd.informirajse.model.exceptions.UserIdNotFoundException;
import mk.awd.informirajse.repository.BlogRepository;
import mk.awd.informirajse.repository.CommentRepository;
import mk.awd.informirajse.repository.UserRepository;
import mk.awd.informirajse.service.BlogService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogServiceImpl implements BlogService {
    private final BlogRepository blogRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    public BlogServiceImpl(BlogRepository blogRepository, UserProfile userProfile, UserRepository userRepository, CommentRepository commentRepository) {
        this.blogRepository = blogRepository;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Blog> findAll() {
        return this.blogRepository.findAll();
    }

    @Override
    public List<Blog> filter(String keyword, String order) {
        List<Blog> blogs;

        if(keyword != null){
            blogs =  this.blogRepository.findByTitleContains(keyword);
        }else{
            blogs = this.blogRepository.findAll();
        }

        switch (order){
            case "":
            case "rastecki":
                blogs = blogs.stream()
                        .sorted(Comparator.comparing(Blog::getDateCreated))
                        .collect(Collectors.toList());
                break;
            case "opagacki":
                blogs = blogs.stream()
                        .sorted(Comparator.comparing(Blog::getDateCreated).reversed())
                        .collect(Collectors.toList());
                break;
            default: break;
        }

        return blogs;
    }

    @Override
    public Blog findById(Long id) {
        return this.blogRepository.findById(id).orElseThrow(BlogNotFoundException::new);
    }

    @Override
    public List<Blog> findBlogsWithMostComments() {
        List<Blog> sortedBlogs = this.blogRepository.findAll().stream()
                .sorted(Comparator.comparingInt(blog -> -blog.getComments().size()))
                .limit(3)
                .toList();

        List<Blog> list = sortedBlogs.stream()
                .sorted(Comparator.comparing(Blog::getDateCreated))
                .collect(Collectors.toList()).stream().toList();

        return list;
    }

    @Override
    public Blog addNewBlog(String title, String summary, String bodyContent, Long userId) {
        User user = this.userRepository.findById(userId).orElseThrow(UserIdNotFoundException::new);
        Blog blog = new Blog(title, summary, bodyContent, user);
        this.blogRepository.save(blog);
        return blog;
    }

    @Override
    public Blog editBlog(Long blogId, String title, String summary, String bodyContent/*, Long userId*/) {
        Blog blog = this.blogRepository.findById(blogId).orElseThrow(BlogNotFoundException::new);
        blog.setTitle(title);
        blog.setSummary(summary);
        blog.setContentBody(bodyContent);
        this.blogRepository.save(blog);
        return blog;
    }

    @Override
    public void delete(Long id) {
        Blog blog = this.findById(id);
        this.blogRepository.delete(blog);
    }


}
