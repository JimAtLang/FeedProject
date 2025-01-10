
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Post {

    private String title;
    private String content;
    private User author;
    private int likes;
    private LocalDateTime postTime;
    private ArrayList<String> keywords;

    public Post(String title, String content, int likes, User author, ArrayList<String> keywords, LocalDateTime postTime) {
        this.title = title;
        this.content = content;
        this.likes = likes;
        this.author = author;
        this.keywords = keywords;
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

    public void addLike() {
        this.likes++;
    }

    public User getAuthor() {
        return author;
    }

    private void setAuthor(User author) {

        this.author = author;
    }

    public ArrayList<String> getKeywords() {
        return keywords;
    }

    private void setKeywords(ArrayList<String> keywords) {
        this.keywords = keywords;
    }

    public void printPost() {
        System.out.println("Title: " + this.title);
        System.out.println("Content:" + this.content);
        System.out.println("Likes: " + this.likes);
        System.out.println("Author: " + this.author);

    }

    public LocalDateTime getPostTime() {
        return postTime;
    }

    public void setPostTime(LocalDateTime postTime) {
        this.postTime = postTime;
    }

}
