
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
            testee.followUser(post.getAuthor());
            if(i>cfPosts.size()*2/3){
                break;
            }
        }
        FeedBuilder cf= new FeedBuilder();
        Feed f=cf.customFeed(testee);
        f.showFeed();
    }

    public static void main(String[] args) throws Exception {
        new App();
    }
    //delete after testing

    Feed customFeed = new Feed();

}
