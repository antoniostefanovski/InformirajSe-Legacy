package mk.awd.informirajse.web;

import mk.awd.informirajse.model.DTO.CommentDTO;
import mk.awd.informirajse.service.CommentService;
import org.apache.coyote.http11.filters.VoidInputFilter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CommentController {
    private final CommentService service;

    public CommentController(CommentService service) {
        this.service = service;
    }

    @PostMapping("/new-comment")
    public ResponseEntity<Void> addNewCommnent(@RequestBody CommentDTO data){
        if(data == null){
            return ResponseEntity.notFound().build();
        }
        this.service.addNewComment(data.commentDescription, data.blogId, data.userId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/delete-comment/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id){
        if(id == null){
            return ResponseEntity.notFound().build();
        }
        this.service.delete(id);
        return ResponseEntity.ok().build();
    }
}
