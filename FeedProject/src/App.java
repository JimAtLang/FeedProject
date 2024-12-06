public class App {
    Tester t;
    public App(){
        MockPostFactory mpf = new MockPostFactory();
        t = new Tester();
    }
    public static void main(String[] args) throws Exception {
        new App();
    }
}
