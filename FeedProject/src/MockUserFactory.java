import java.util.ArrayList;
import java.util.Random;

public class MockUserFactory {
    DataReader dr;
    Random r;
    private ArrayList<String> keywords;
    public MockUserFactory(){
        dr = new DataReader();
        r = new Random();
        keywords = new ArrayList<String>(dr.readCategories().keySet());
    }

    public User generateeUser(){
        ArrayList<String> interests = new ArrayList<>();
        for(String keyword:keywords){
            if(r.nextInt(100)<50){
                interests.add(keyword);
            }
        }
        int userNameLength = r.nextInt(5) + 4;
        char[] usernameChars = new char[userNameLength];
        for(int i=0;i<userNameLength;i++){
            usernameChars[i] = (char)(r.nextInt(26)+'a');
        }
        String username = new String(usernameChars);
        User u = new User(username);
        u.setInterests(interests);
        return u;
    }
}
