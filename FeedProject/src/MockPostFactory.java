import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class MockPostFactory {

    private String[] keywords;
    private String[] titles = {
        "5 Tips for {action} to Boost {benefit}!",
        "The Ultimate Guide to {topic}",
        "How to {goal} in {timeframe}",
        "Top 10 {items} for {outcome}",
        "Why {concept} is Important for {benefit}"
    };
    private String[] contentStrings;
    private HashMap<String, String[]> categories;

    public MockPostFactory(){
        
    }

    public ArrayList<String> readFile(String fileName){
        ArrayList<String> rtrn = new ArrayList<>();
        FileReader f;
        try{
            f = new FileReader(fileName);
            BufferedReader br = new BufferedReader(f);
        } catch (FileNotFoundException e){
            System.out.println(e);
        }
        return rtrn;
    }


}
