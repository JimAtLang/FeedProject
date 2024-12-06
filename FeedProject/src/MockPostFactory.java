import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class MockPostFactory {

    private ArrayList<String> keywords;
    private ArrayList<String> titles;
    private ArrayList<String> contentStrings;
    private HashMap<String, ArrayList<String>> categories;
    private ArrayList<String[]> replace_text;
    private ArrayList<String[]> replace_title;

    public MockPostFactory(){
        titles = readLines("titles.txt");
        contentStrings = readLines("content.txt");
        categories = readCategories();
        keywords = new ArrayList<String>(categories.keySet());
        replace_text = readReplace("replace_text.txt");
        replace_title = readReplace("replace_title.txt");
    }

    private ArrayList<String[]> readReplace(String fileName){
        ArrayList<String[]> rtrn = new ArrayList<>();
        ArrayList<String> lines = readLines(fileName);
        for(String line:lines){
            rtrn.add(line.split("-"));
        }
        return rtrn;
    }

    private HashMap<String, ArrayList<String>> readCategories(){
        HashMap<String, ArrayList<String>> rtrn = new HashMap<>();
        ArrayList<String> lines = readLines("categories.txt");
        for(String line:lines){
            String[] splitLine = line.split(":");
            ArrayList<String> phraseList = new ArrayList<>();
            for(String phrase:splitLine[1].split(",")){
                phraseList.add(phrase);
            }
            rtrn.put(splitLine[0],phraseList);
        }
        return rtrn;
    }

    private ArrayList<String> readLines(String fileName){
        ArrayList<String> rtrn = new ArrayList<>();
        FileReader f;
        try{
            f = new FileReader(fileName);
            BufferedReader br = new BufferedReader(f);
            String line;
            while((line = br.readLine()) != null){
                rtrn.add(line);
            }
        } catch (FileNotFoundException e){
            System.out.println(e);
        } catch (IOException e){
            System.out.println(e);
        }
        return rtrn;
    }


}
