import java.time.LocalDateTime;
import java.util.ArrayList;

public class Post {
    private User author;
    private String title;
    private String content;
    private int likes;
    private LocalDateTime postTime;
    private ArrayList<String> keywords;
    public User getAuthor() {
        return author;
    }
    public void setAuthor(User author) {
        this.author = author;
    }
    public ArrayList<String> getKeywords() {
        return keywords;
    }
    public void setKeywords(ArrayList<String> keywords) {
        this.keywords = keywords;
    }
    public Post(String title, String content, int likes) {
        this.title = title;
        this.content = content;
        this.likes = likes;
        this.keywords = new ArrayList<>();
    }
    public Post(String title, String content, int likes, LocalDateTime postTime) {
        this.title = title;
        this.content = content;
        this.likes = likes;
        this.postTime = postTime;
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

    private boolean isRelatedLastPost(Post p, User u){
        Post l = u.getLastPost()
        for (String i: l.getKeywords()){
            if (i in p.getKeywords()){
                return true
            }
        }
        return false
    }

    private boolean isTrending(Post p){
        if (p.getPostTime()</*3 months*/||p.getLikes()>100){
            return true
        }
        return false
        
    }

}
