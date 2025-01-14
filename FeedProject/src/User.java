
import java.time.LocalDateTime;
import java.util.ArrayList;

public class User {

    private String userName;
    private ArrayList<User> follows;
    private ArrayList<Post> postHistory;
    private ArrayList<String> interests;

    public ArrayList<String> getInterests() {
        return interests;
    }

    public void setInterests(ArrayList<String> interests) {
        this.interests = interests;
    }

    public User(String userName) {
        this.userName = userName;
        this.follows = new ArrayList<>();
        this.postHistory = new ArrayList<>();
        this.interests = new ArrayList<>();

    }

    public ArrayList<Post> getPostHistory() {
        return postHistory;
    }

    public void post(String title, String content, int likes, User author, ArrayList<String> keywords, LocalDateTime postTime) {
        Post post = new Post(title, content, likes, author, keywords, postTime);
        postHistory.add(post);
    }

    public void post(Post p) {
        postHistory.add(p);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void followUser(User user) {
        follows.add(user);
    }

    public ArrayList<User> getFollows() {
        return follows;
    }
}
