package notesappcom.example.notesapp.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import notesappcom.example.notesapp.pojo.Post;
@Repository
public class NotesRepo {
        private List<Post> posts = new ArrayList<>(); 

        //Create CRUD Opperations 

        //Create Post 
        public void createPost(Post post){
            this.posts.add(post); 
        }

        //Read Post/s
        public List<Post> getPosts(){
            return posts; 
        } 

        public List<Post> getPostByUserid(List<Post> posts, String id){
            List<Post> postById = new ArrayList<>(); 
            for (Post post : posts) {
               if(post.getId().equals(id)){
                postById.add(post); 
               }
            }
            return postById;
        }

        public Post getPostByIndex(int index){
            return posts.get(index); 

        }

        //Update
        public Post updatePost(int index, String newTitle, String newBody){
           
            if(index < 0 || index >= posts.size()){
                System.out.println("Index out of bounds");
            }
            Post post = posts.get(index);
            
            if (newTitle != null && !newTitle.trim().isEmpty()) {
                post.setTitle(newTitle);
            }
        
            if (newBody != null && !newBody.trim().isEmpty()) {
                post.setBody(newBody);
            }
        
            return post;

           
    }
        //Delete Post
        public void deletePost(int index){
            posts.remove(index); 
            
        }
    
}

    


