import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.ArrayList;
public class Post {
    private String title;
    private String content;
    private int likes;
    private LocalDateTime postTime;
    private String author;
    private ArrayList<String> keywords;

    
    public Post(String title, String content, int likes, LocalDateTime postTime, String author, ArrayList<String> keywords) {
        this.title = title;
        this.content = content;
        this.likes = likes;
        this.postTime = postTime;
        this.author=author;
        this.keywords=keywords;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public int getLikes() {
        return likes;
    }
    public void setLikes(int likes) {
        this.likes = likes;
    }
    public void addLike(){
        this.likes++;
    }
    private void setAuthor(String author){
        this.author=author;
    }
    public String getAuthor(){
        return author;
    }
    private void setKeywords(ArrayList keywords){
        this.keywords=keywords;
    }
    public ArrayList<String> getKeywords(){
        return keywords;
    }

    public void printPost(){
        System.out.println("Title: " + this.title);
        System.out.println("Content:" + this.content);
        System.out.println("Likes: " + this.likes);

    }
    public LocalDateTime getPostTime() {
        return postTime;
    }
    public void setPostTime(LocalDateTime postTime) {
        this.postTime = postTime;
    }

}
