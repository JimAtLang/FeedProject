import java.time.LocalDateTime;
import java.util.ArrayList;

public class Post {
    private String title;
    private String content;
    private int likes;
    private LocalDateTime postTime;
    private ArrayList<String> keywords;
    public ArrayList<String> getKeywords() {
        return keywords;
    }
    public Post(String title, String content, int likes, LocalDateTime postTime) {
        this.title = title;
        this.content = content;
        this.likes = likes;
        this.postTime = postTime;
        this.keywords = new ArrayList<>();
    }
    public void addKeyword(String keyword){
        this.keywords.add(keyword);
    }
    public boolean hasKeyword(String keyword){
        return this.keywords.contains(keyword);
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
