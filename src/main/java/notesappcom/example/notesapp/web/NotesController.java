package notesappcom.example.notesapp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import notesappcom.example.notesapp.exception.NoContactException;
import notesappcom.example.notesapp.pojo.Post;
import notesappcom.example.notesapp.service.NotesService;
import notesappcom.example.notesapp.service.PostUpdateRequest;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
public class NotesController {

    @Autowired
    private NotesService notesService;

    //get all notes
    @GetMapping("/all")
    public ResponseEntity <List<Post>> getAllPosts() {
        List<Post> posts = notesService.getPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }
    //get note by ID
        @GetMapping("/post/{id}")
        public ResponseEntity<Post> getPostByIndex(int index) {
            try {
                Post post = notesService.getPostByIndex(index);
                if (post == null) {
                    throw new NoContactException();
                }
                return new ResponseEntity<>(post, HttpStatus.OK);
            } catch (NoContactException e) {
                return new ResponseEntity<>(HttpStatus.BAD_GATEWAY); 
            }
        }
    //create note
    @PostMapping("/post/create")
    public ResponseEntity<HttpStatus> createPost(@RequestBody Post post){
        notesService.createPost(post); 
        return new ResponseEntity<>(HttpStatus.OK); 

    }

    
 //Update Note
@PutMapping("/post/update/{index}")
public ResponseEntity<Post> updatePost(@PathVariable int index, @RequestBody PostUpdateRequest updateRequest) {
    try {
        String newTitle = updateRequest.getTitle();
        String newBody = updateRequest.getBody();
        Post updatedPost = notesService.updatePost(index, newTitle, newBody);
        return ResponseEntity.ok(updatedPost);
        
    } catch (IndexOutOfBoundsException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}

 //Delete Note
 @DeleteMapping("/post/delete/{index}")
 public ResponseEntity<HttpStatus> deletePost(@PathVariable int index){
    try {
        notesService.deletePost(index);
        return new ResponseEntity<>(HttpStatus.OK); 
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.FORBIDDEN); 
    }
    
 }


}



   
   
    

