package mk.awd.informirajse.service;

import mk.awd.informirajse.model.Blog;
import mk.awd.informirajse.model.User;

import java.util.List;

public interface BlogService {
    public List<Blog> findAll();
    public Blog findById(Long id);
    public List<Blog> findBlogsWithMostComments();
    public Blog addNewBlog(String  title, String summary, String bodyContent, Long userId);
    public Blog editBlog(Long blogId, String  title, String summary, String bodyContent/*, Long userId*/);
    public void delete(Long id);
}
