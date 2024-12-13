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

   public MockPostFactory(){
        dr = new DataReader();
        random = new Random();
        titles = dr.readLines("titles.txt");
        contentStrings = dr.readLines("content.txt");
        categories = dr.readCategories();
        keywords = new ArrayList<String>(categories.keySet());
        replace_text = dr.readReplace("replace_text.txt");
        replace_title = dr.readReplace("replace_title.txt");
    }

    public Post makePost(int daysBeforeNow, int dayRange){
        return null;
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
