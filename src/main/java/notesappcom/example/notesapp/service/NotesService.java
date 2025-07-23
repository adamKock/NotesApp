package notesappcom.example.notesapp.service;
import java.util.List;

import notesappcom.example.notesapp.pojo.Post;

public interface NotesService {

    //Interface class that forces the implementations of the below methods. 
    //These methods should also algin with the NotesRepoClass
    
    void createPost(Post post);
    public List<Post> getPosts();
    public Post getPostByIndex(int index);
    public Post updatePost(int index, String newTitle, String newBody);
    public void deletePost(int index);

    


    
}
