
import java.rmi.server.UID;
import java.time.LocalDateTime;
import java.util.Random;
import javax.swing.UIClientPropertyKey;

public class Tester {

    Random r;
    FeedBuilder fb;

    public Tester() {
        r = new Random();
        fb = new FeedBuilder();
    }

    private String generateUserName() {
        int usernameLength = r.nextInt(3) + 4;
        String username = "";
        for (int i = 0; i < usernameLength; i++) {
            username += (char) r.nextInt(26) + 97;
        }
        return username;
    }

    private User generateUser() {
        User u = new User(generateUserName());
        SocialMediaPostGenerator smpg = new SocialMediaPostGenerator();
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime twoDaysAgo = now.minusDays(14);
        LocalDateTime postDate = twoDaysAgo;
        while (postDate.isBefore(now)) {
            System.out.println("generating post for user" + u.getUserName() + " on post date " + postDate);
            u.post(smpg.generatePostWithDate(postDate));
            postDate = postDate.plusMinutes(r.nextInt(12 * 60));
        }
        return u;
    }

    public void TestChronologicalFeed() {
        System.out.println("testing chrono feed");
        User u = new User(generateUserName());
        int numFollowed = 2;
        for (int i = 0; i < numFollowed; i++) {
            u.followUser(generateUser());
        }
        Feed cf = fb.chronologicalFeed(u);
        LocalDateTime prevDateTime = cf.getPosts().get(0).getPostTime();
        for (Post p : cf.getPosts()) {
            LocalDateTime pt = p.getPostTime();
            System.out.println("Title: " + p.getTitle());
            System.out.println("Post date:" + pt);
            if (pt.isAfter(prevDateTime)) {
                System.out.println("OUT OF ORDER");
            }
            prevDateTime = pt;
        }
    }

    public void testCustomFeed() {
        int a = 0;
        int b = 0;
        for (Post p : customFeed.getPosts()) {
            if (a < 5) {
                assert (p.getAuthor().indexOf(u.getFollows()) == -1);
                a++;
                b++;
            } else if (b == 20) {
                assert (!p.getAuthor().indexOf(u.getFollows()) == -1);
                b = 0;
            } else {
                assert (p.getKeywords().indexOf(u.getInterests()) > 0);
                a = 0;
            }
            if(a==100){
                return;
            }
        }
    }
}
