
import java.time.LocalDateTime;

public class Post {

    private String title;
    private String content;
    private String author;
    private int likes;
    private LocalDateTime postTime;
    private String keywords;

    public Post(String title, String content, int likes, String author, String keywords) {
        this.title = title;
        this.content = content;
        this.likes = likes;
        this.author = author;
        this.keywords = keywords;
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

    public void addLike() {
        this.likes++;
    }

    public String getAuthor(String author) {
        return author;
    }

    private void setAuthor() {
        this.author = author;
    }

    public String getKeywords() {
        return keywords;
    }

    private void setKeywords() {
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
