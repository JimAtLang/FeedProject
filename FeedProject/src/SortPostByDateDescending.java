import java.util.Comparator;

public class SortPostByDateDescending implements Comparator<Post>{
    public int compare(Post a, Post b){
        return b.getPostTime().compareTo(a.getPostTime());
    }
}
