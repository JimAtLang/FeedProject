import java.time.LocalDateTime;
import java.util.Random;

public class Tester {
    Random r;
    FeedBuilder fb;
    public Tester(){
        r = new Random();
        fb = new FeedBuilder();
    }
    private String generateUserName(){
        int usernameLength = r.nextInt(3)+4;
        String username = "";
        for(int i=0;i<usernameLength;i++){
            username += (char)r.nextInt(26)+97;
        }
        return username;
    }
    private User generateUser(){
        User u = new User(generateUserName());
        SocialMediaPostGenerator smpg = new SocialMediaPostGenerator();
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime twoDaysAgo = now.minusDays(14);
        LocalDateTime postDate = twoDaysAgo;
        while(postDate.isBefore(now)){
            System.out.println("generating post for user" + u.getUserName() + " on post date " + postDate);
            u.post(smpg.generatePostWithDate(postDate));
            postDate = postDate.plusMinutes(r.nextInt(12*60));
        }
        return u;
    }

    public void testMyFeed(Feed f, User u){
        int followedNum = 0;
        int relatedNum = 0;
        int trendingNum = 0;
        int unrelatedNum = 0;
        for(Post p: f.getPosts()){
            if (u.getFollows().contains(p.getAuthor())){
                followedNum++;
            }
            if (u.isRelatedLastPost(p)){
                relatedNum++;
            }
            if (p.isTrending(p)){
                trendingNum++;
            }
            if (!u.isRelatedLastPost(p)){
                unrelatedNum++;
            }
        }
        assert(relatedNum>followedNum||followedNum>trendingNum||trendingNum>unrelatedNum);
    } 

    public void TestChronologicalFeed(){
        System.out.println("testing chrono feed");
        User u = new User(generateUserName());
        int numFollowed = 2;
        for(int i=0;i<numFollowed;i++){
            u.followUser(generateUser());
        }
        Feed cf = fb.chronologicalFeed(u);
        LocalDateTime prevDateTime = cf.getPosts().get(0).getPostTime();
        for(Post p:cf.getPosts()){
            LocalDateTime pt = p.getPostTime();
            System.out.println("Title: " + p.getTitle());
            System.out.println("Post date:" + pt);
            if(pt.isAfter(prevDateTime)){
                System.out.println("OUT OF ORDER");
            }
            prevDateTime = pt;
        }
    }
}