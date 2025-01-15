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

    public Feed myFeed(User user, ArrayList<Post> allPosts){
        ArrayList<User> followedUsers = user.getFollows();
        Feed f = new Feed();
        ArrayList<Post> posts = new ArrayList<>();
        for (User followedUser:followedUsers){
            posts.add(followedUser.getLastPost());
        }
        for (Post p:allPosts){
            if (p.isTrending(p)||!posts.contains(p)){
                posts.add(p);
            }
        }
        // TODO: Add related and unrelated
        f.addAllPosts(posts);
        return null;
    }
}
