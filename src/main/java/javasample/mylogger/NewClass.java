package javasample.mylogger;

public class NewClass {

    private static MyLogger logger = new MyLogger(NewClass.class);

    public int newMethod() throws InterruptedException {
        logger.start();

        int i = 99;
        Thread.sleep(98);

        logger.debug("return i = {}", i);
        logger.end();
        return i;
    }
}
