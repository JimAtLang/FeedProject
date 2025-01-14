import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class DataReader {
    private String path;
    public DataReader(){
        File directory = new File("./");
        this.path = directory.getAbsolutePath();
        this.path = this.path.substring(0,this.path.length()-1);
        System.out.println("created DataReader at path " + path);
    }
    public ArrayList<String[]> readReplace(String fileName){
        ArrayList<String[]> rtrn = new ArrayList<>();
        ArrayList<String> lines = readLines(fileName);
        for(String line:lines){
            rtrn.add(line.split("-"));
        }
        return rtrn;
    }

    public HashMap<String, ArrayList<String>> readCategories(){
        HashMap<String, ArrayList<String>> rtrn = new HashMap<>();
        ArrayList<String> lines = readLines("FeedProject/src/data/categories.txt");
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

    public ArrayList<String> readLines(String fileName){
        String filePath = path + fileName;
        ArrayList<String> rtrn = new ArrayList<>();
        FileReader f;
        try{
            f = new FileReader(filePath);
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
