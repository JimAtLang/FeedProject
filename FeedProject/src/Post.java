
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Post {

    private String title;
    private String content;
    private String author;
    private int likes;
    private LocalDateTime postTime;
<<<<<<< HEAD
    private String keywords;

    public Post(String title, String content, int likes, String author, String keywords) {
        this.title = title;
        this.content = content;
        this.likes = likes;
        this.author = author;
        this.keywords = keywords;
=======
    private ArrayList<String> keywords;
    private User author;
    public Post(String title, String content, int likes, LocalDateTime postTime, User author, ArrayList<String> keywords) {
        this.title = title;
        this.content = content;
        this.likes = likes;
        this.postTime = postTime;
        this.author = author;
        this.keywords = keywords;
    }
    public Post(String title, String content, int likes, LocalDateTime postTime, User author) {
        this.title = title;
        this.content = content;
        this.likes = likes;
        this.postTime = postTime;
        this.author = author;
        this.keywords = new ArrayList<>();
>>>>>>> 2fb67207bfeb639c01c67a2a33a8caeacfdf408c
    }

    public Post(String title, String content, int likes, LocalDateTime postTime) {
        this.title = title;
        this.content = content;
        this.likes = likes;
        this.postTime = postTime;
        this.keywords = new ArrayList<>();
    }
    public User getAuthor() {
        return author;
    }
    public void setAuthor(User author) {
        this.author = author;
    }
    public ArrayList<String> getKeywords() {
        return keywords;
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
<<<<<<< HEAD
        System.out.println("Author: " + this.author);
=======
        System.out.println("author:" + this.author.getUserName());
        System.out.println("postTime: " + this.postTime);
        for(String keyword:this.keywords){
            System.out.println(keyword);
        }
>>>>>>> 2fb67207bfeb639c01c67a2a33a8caeacfdf408c

    }

    public LocalDateTime getPostTime() {
        return postTime;
    }

    public void setPostTime(LocalDateTime postTime) {
        this.postTime = postTime;
    }

}
