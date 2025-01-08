import java.util.ArrayList;

public class App {
    Tester t;
    public App(){
        MockPostFactory mpf = new MockPostFactory();
        ArrayList<Post> posts = mpf.makePosts(5);
        for(Post post:posts){
            post.printPost();
        }
    }
    public static void main(String[] args) throws Exception {
        new App();
    }
}
