import java.util.ArrayList;
import java.util.List;

public class Feed {
    private List<Post> posts;
    public List<Post> getPosts() {
        return posts;
    }
    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
    public Feed(){
        this.posts = new ArrayList<>();
    }
    public void addAllPosts(List<Post> posts){
        this.posts.addAll(posts);
    }    

    public void showFeed(){
        for(Post post:posts){
            post.printPost();
        }
    }

    // TODO: create a mostPopularPost() method that returns the post with the most likes
    public Post mostPopularPost(){
        Post mostPopular = this.posts.get(0);
        for(Post p:this.posts){
            if(p.getLikes()>mostPopular.getLikes()){
                mostPopular = p;
            }
        }
        return mostPopular;
    }
}