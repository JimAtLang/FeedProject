
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

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
        int a = 0;
        int b = 0;
        MockPostFactory mpf = new MockPostFactory();
        Random r = new Random();
        Feed customFeed = new Feed();
        ArrayList<Post> list = new ArrayList<>();
        for (User followedUser : user.getFollows()) {
            //Create loop to add the posts for a=5, b=20 etc
            //User u.follows, get a random post from followed user, first showing unssen posts, then viewed posts
            if (a < 20) {
                int randomFollow = r.nextInt(0, user.getFollows().size());
                int randomPost = r.nextInt(0, user.getPostHistory().size());
                list.add(user.getFollows().get(randomFollow).getPostHistory().get(randomPost));
                a++;
                b++;
            } else if (b == 20) {
                //get a completely random post
                mpf.makePosts(1);
                b=0;
                a=0;
            }
        }
        customFeed.setPosts(list);
        return customFeed;
    }
}
