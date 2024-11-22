public class App {
    Tester t;
    public App(){
        t = new Tester();
        t.testAssert();
    }
    public static void main(String[] args) throws Exception {
        new App();
    }
}
