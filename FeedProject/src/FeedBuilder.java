
import java.util.ArrayList;
import java.util.Collections;

public class FeedBuilder {

    public Feed chronologicalFeed(User user) {
        Feed f = new Feed();
        ArrayList<Post> list = new ArrayList<>();
        for (User followedUser : user.getFollows()) {
            for (Post p : followedUser.getPostHistory()) {
                list.add(p);
            }
        }
        Collections.sort(list, new SortPostByDateDescending());
        f.addAllPosts(list);
        return f;
    }

    public Feed customFeed(User user) {
        Feed cf = new Feed();
        ArrayList<Post> list = new ArrayList<>();
        int a=0;
        int b=0;
        for (User followedUser : user.getFollows()) {
            //Create loop to add the posts for a=5, b=20 etc
            if(a<5){
                list.add(followedUser.getLastPost());
            }
            if(b=20){
                //generate random post
            }
        }
        return posts;
    }
}
