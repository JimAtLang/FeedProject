
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class SocialMediaPostGenerator {
    Random random = new Random();
    public SocialMediaPostGenerator(){
        int numberOfPosts = 10000; // Set this to 1000 for full generation
        generatePosts(numberOfPosts);
    }

    // Define templates and categories
    private static final String[] TITLES = {
            "5 Tips for {action} to Boost {benefit}!",
            "The Ultimate Guide to {topic}",
            "How to {goal} in {timeframe}",
            "Top 10 {items} for {outcome}",
            "Why {concept} is Important for {benefit}"
    };

    private static final Map<String, String[]> CATEGORIES = new HashMap<>() {{
        put("Productivity", new String[]{"time management", "focus", "planning"});
        put("Health and Fitness", new String[]{"workout", "nutrition", "home gym"});
        put("Travel", new String[]{"hidden gems", "budget travel", "destinations"});
    }};

    private static final String[] TEXTS = {
            "Feeling overwhelmed? Try these {number} simple tips to {action} and improve {benefit}.",
            "Learn how to {goal} with our ultimate guide. From {step1} to {step2}, we cover it all!",
            "Staying motivated can be tough, but with these {items}, you'll be on track in no time."
    };

    public LocalDateTime getRandomDateInNextFiveDays() {

        // Get the current date and time
        LocalDateTime now = LocalDateTime.now();
        
        // Generate a random number of seconds from now to five days from now
        long secondsInFiveDays = 5 * 24 * 60 * 60; // 5 days in seconds
        long randomSeconds = random.nextLong(0, secondsInFiveDays);

        // Add the random seconds to the current date and time
        return now.plusSeconds(randomSeconds);
    }

    public Post generatePost(){
        List<String> categoryKeys = new ArrayList<>(CATEGORIES.keySet());
        String category = categoryKeys.get(random.nextInt(categoryKeys.size()));

        // Select random keywords from the chosen category
        String[] keywordsArray = CATEGORIES.get(category);
        String keywords = keywordsArray[random.nextInt(keywordsArray.length)];

        // Generate random title
        String title = TITLES[random.nextInt(TITLES.length)]
                .replace("{action}", "boost productivity")
                .replace("{benefit}", "focus")
                .replace("{topic}", keywords)
                .replace("{goal}", "achieve your goals")
                .replace("{timeframe}", "30 days")
                .replace("{items}", "tools")
                .replace("{outcome}", "success")
                .replace("{concept}", "self-care");

        // Generate random text
        String text = TEXTS[random.nextInt(TEXTS.length)]
                .replace("{number}", "5")
                .replace("{action}", "stay organized")
                .replace("{benefit}", "mental clarity")
                .replace("{goal}", "manage your time")
                .replace("{step1}", "set goals")
                .replace("{step2}", "track progress")
                .replace("{items}", "apps and tips");

        int likes = random.nextInt(500);
        ArrayList<String> keywordsList = new ArrayList<>();
        Collections.addAll(keywordsList,keywordsArray);
        Post newPost = new Post(title, text, likes);
        return newPost;
    }

    public Post generatePostWithDate(LocalDateTime date){
        Post newPost = generatePost();
        newPost.setPostTime(date);
        return newPost;
    }

    public ArrayList<Post> generatePosts(int count) {
        
        ArrayList<Post> posts = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            // Select random category
            posts.add(generatePost());
        }
        return posts;
    }


}
