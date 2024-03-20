package mk.awd.informirajse.web;

import mk.awd.informirajse.config.UserProfile;
import mk.awd.informirajse.model.Blog;
import mk.awd.informirajse.model.DTO.BlogDTO;
import mk.awd.informirajse.model.DTO.SearchDTO;
import mk.awd.informirajse.service.BlogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BlogController {
    private final BlogService service;
    private final UserProfile userProfile;

    public BlogController(BlogService service, UserProfile userProfile) {
        this.service = service;
        this.userProfile = userProfile;
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<Blog>> findAll(@RequestBody(required = false) SearchDTO searchTerm){
        List<Blog> blogs = null;
        if(searchTerm.keyword == null && searchTerm.order == null){
            blogs = this.service.findAll();
        }else{
            blogs = this.service.filter(searchTerm.keyword, searchTerm.order);
        }
        return ResponseEntity.ok(blogs);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<Blog> findById(@PathVariable Long id){
        if(id == null){
            return ResponseEntity.notFound().build();
        }else if(this.service.findById(id) == null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(this.service.findById(id));
        }
    }

    @GetMapping("/most-interesting")
    public ResponseEntity<List<Blog>> mostInterestingBlogs(){
        List<Blog> blogs = this.service.findBlogsWithMostComments();
        if(blogs == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(blogs);
    }

    @GetMapping("/delete-blog/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        if(id == null){
            return ResponseEntity.notFound().build();
        }
        this.service.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/new-blog")
    public ResponseEntity<Void> newBlog(@RequestBody BlogDTO data){
        if(data == null){
            return ResponseEntity.notFound().build();
        }
        this.service.addNewBlog(data.title, data.summary, data.bodyContent, data.userId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/edit-blog/{id}")
    public ResponseEntity<Void> editBlog(@PathVariable Long id, @RequestBody BlogDTO data){
        if(data == null){
            return ResponseEntity.notFound().build();
        }
        this.service.editBlog(id, data.title, data.summary, data.bodyContent/*, data.userId*/);
        return ResponseEntity.ok().build();
    }
}
