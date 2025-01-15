
import java.util.ArrayList;

public class App {

    public App() {
        ArrayList<Post> posts = new ArrayList<>();
        //Post p= new Post("a post","abcdef",0,LocalDateTime.now(), "Yaboy", "cars"); 
        MockPostFactory mpf = new MockPostFactory();
        int i=0;
        ArrayList<Post> cfPosts = mpf.makePosts(150);
        User testee=cfPosts.get(0).getAuthor();
        for (Post post : posts) {
            //user.follow();
            testee.followUser(post.getAuthor());
            if(i>cfPosts.size()*2/3){
                break;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new App();
    }
    //delete after testing

    Feed customFeed = new Feed();

}
