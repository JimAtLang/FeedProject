import java.util.ArrayList;

public class MockUserFactory {
    DataReader dr;
    private ArrayList<String> keywords;
    public MockUserFactory(){
        dr = new DataReader();
        keywords = dr.readLines("categories.txt");
    }
}
