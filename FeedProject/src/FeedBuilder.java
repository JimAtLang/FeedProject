import java.util.ArrayList;
import java.util.Collections;

public class FeedBuilder {
    public Feed chronologicalFeed(User user){
        Feed f = new Feed();
        ArrayList<Post> list = new ArrayList<>();
        for (User followedUser:user.getFollows()){
            for (Post p:followedUser.getPostHistory()){
                list.add(p);
            }
        }
        Collections.sort(list, new SortPostByDateDescending());
        f.addAllPosts(list);
        return f;
    }
}
