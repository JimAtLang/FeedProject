
import java.util.ArrayList;

public class App {

    public App() {
        ArrayList<Post> posts = new ArrayList<>();
        //Post p= new Post("a post","abcdef",0,LocalDateTime.now(), "Yaboy", "cars"); 

        MockPostFactory mpf = new MockPostFactory();
        ArrayList<Post> cfPosts = mpf.makePosts(20);
        for (Post post : posts) {
            post.printPost();
        }
    }

    public static void main(String[] args) throws Exception {
        new App();
    }
    //delete after testing

    Feed customFeed = new Feed();

}
