import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MockPostFactory {

    private ArrayList<String> keywords;
    private ArrayList<String> titles;
    private ArrayList<String> contentStrings;
    private HashMap<String, ArrayList<String>> categories;
    private ArrayList<String[]> replace_text;
    private ArrayList<String[]> replace_title;
    private DataReader dr;
    private Random random;
    private MockUserFactory muf;

   public MockPostFactory(){
        dr = new DataReader();
        random = new Random();
        titles = dr.readLines("src/data/titles.txt");
        contentStrings = dr.readLines("src/data/content.txt");
        categories = dr.readCategories();
        keywords = new ArrayList<String>(categories.keySet());
        replace_text = dr.readReplace("src/data/replace_text.txt");
        replace_title = dr.readReplace("src/data/replace_title.txt");
        muf = new MockUserFactory();
    }

    public ArrayList<Post> makePosts(int number){
        ArrayList<Post> posts = new ArrayList<>();
        for(int i=0; i < number; i++){
            int daysBeforeNow = 50;
            int dayRange = random.nextInt(daysBeforeNow);
            posts.add(makePost(daysBeforeNow, dayRange));
        }
        return posts;
    }

    public Post makePost(User author, int daysBeforeNow, int dayRange){
        LocalDateTime postTime = getRandomDate(daysBeforeNow, dayRange);
        ArrayList<String> keywords = new ArrayList<>();
        ArrayList<String> categoryStrings = new ArrayList<String>(categories.keySet());
        String mainCategory = categoryStrings.get(random.nextInt(categoryStrings.size()));
        keywords.add(mainCategory);
        for(String subcategory:categories.get(mainCategory)){
            if(random.nextInt(100)<30){
                keywords.add(subcategory);
            }
        }
        String title = "";
        for(String keyword:keywords){
            title += keyword;
        }
        int likes = random.nextInt(1000);

        return new Post(title, "content", likes, postTime, author, keywords);
    }

    public Post makePost(int daysBeforeNow, int dayRange){
        User author = muf.generateUser();
        LocalDateTime postTime = getRandomDate(daysBeforeNow, dayRange);
        ArrayList<String> keywords = new ArrayList<>();
        ArrayList<String> categoryStrings = new ArrayList<String>(categories.keySet());
        String mainCategory = categoryStrings.get(random.nextInt(categoryStrings.size()));
        keywords.add(mainCategory);
        for(String subcategory:categories.get(mainCategory)){
            if(random.nextInt(100)<30){
                keywords.add(subcategory);
            }
        }
        String title = "";
        for(String keyword:keywords){
            title += keyword;
        }
        int likes = random.nextInt(1000);

        return new Post(title, "content", likes, postTime, author, keywords);
    }

    private LocalDateTime getRandomDate(int daysBeforeNow, int dayRange) {

        // Get the current date and time
        LocalDateTime startTime = LocalDateTime.now().minusDays(daysBeforeNow);
        // Generate a random number of seconds from now to five days from now
        long secondsInDayRange = dayRange * 24 * 60 * 60; // 5 days in seconds
        long randomSeconds = random.nextLong(0, secondsInDayRange);

        // Add the random seconds to the current date and time
        return startTime.plusSeconds(randomSeconds);
    }


 }
