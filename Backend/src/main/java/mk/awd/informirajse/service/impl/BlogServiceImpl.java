package mk.awd.informirajse.service.impl;


import mk.awd.informirajse.config.UserProfile;
import mk.awd.informirajse.model.Blog;
import mk.awd.informirajse.model.User;
import mk.awd.informirajse.model.exceptions.BlogNotFoundException;
import mk.awd.informirajse.model.exceptions.UserIdNotFoundException;
import mk.awd.informirajse.repository.BlogRepository;
import mk.awd.informirajse.repository.UserRepository;
import mk.awd.informirajse.service.BlogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    private final BlogRepository blogRepository;
    private final UserRepository userRepository;

    public BlogServiceImpl(BlogRepository blogRepository, UserProfile userProfile, UserRepository userRepository) {
        this.blogRepository = blogRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Blog> findAll() {
        return this.blogRepository.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return this.blogRepository.findById(id).orElseThrow(BlogNotFoundException::new);
    }

    @Override
    public List<Blog> findBlogsWithMostComments() {
//        return this.blogRepository.findAll()
//                .stream()
//                .sorted(Comparator.comparingInt(blog -> blog.getComments().size()).reversed())
//                .limit(10)
//                .collect(Collectors.toList());
        return null;
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
        System.out.println(blog.toString());
        this.blogRepository.delete(blog);
    }


}
