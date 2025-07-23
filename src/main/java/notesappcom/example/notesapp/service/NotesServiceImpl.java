package notesappcom.example.notesapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import notesappcom.example.notesapp.pojo.Post;
import notesappcom.example.notesapp.repository.NotesRepo;

@Service
public class NotesServiceImpl implements NotesService {
    @Autowired 
    private NotesRepo NotesRepo;


    @Override
    public void createPost(Post post) {
        NotesRepo.createPost(post);
    }

    @Override
    public List<Post> getPosts() {
       return NotesRepo.getPosts();
    }

    @Override
    public Post getPostByIndex(int index) {
        return NotesRepo.getPostByIndex(index);
    }

    @Override
    public Post updatePost(int index, String newTitle, String newBody) {
       return NotesRepo.updatePost(index, newTitle, newBody);
    }

    @Override
    public void deletePost(int index) {
        NotesRepo.deletePost(index);
    }

  



    
    
}
