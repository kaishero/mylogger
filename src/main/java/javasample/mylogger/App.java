package javasample.mylogger;

public class App {

    private static MyLogger logger = new MyLogger(App.class);

    public static void main(String[] args) throws InterruptedException {
        logger.thredStart();

        Thread.sleep(50);
        
        appMethod("abc");

        NewClass obj = new NewClass();
        obj.newMethod();

        logger.thredEnd();
    }

    private static void appMethod(String str) throws InterruptedException {
        logger.start();
        logger.debug("param str = {}", str);
        Thread.sleep(80);
        logger.end();
    }
}
