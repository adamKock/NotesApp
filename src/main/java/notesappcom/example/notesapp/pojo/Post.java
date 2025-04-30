package notesappcom.example.notesapp.pojo;

public class Post {

    private String title;
    private String body;
    private String userId;  

    public Post(String title, String body, String userId) {
        this.title = title;
        this.body = body;
        this.userId = userId; 
    }

    public String getTitle(){
        return title;
    }

    public String getBody(){
        return body; 
    }

    public String getId(){
        return userId; 
    }

    public void setTitle(String title){
        this.title= title; 
    }

    public void setBody(String body){
        this.body= body; 
    }


    




    
}
