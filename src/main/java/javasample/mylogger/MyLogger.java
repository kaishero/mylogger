package javasample.mylogger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyLogger {

    private Logger logger;
    private static ThreadLocal<Long> time = new ThreadLocal<Long>() {
        @Override
        protected Long initialValue() {
            return null;
        }
    };

    private MyLogger() {
    }

    public MyLogger(final Class clazz) {
        this.logger = LoggerFactory.getLogger(clazz);
    }

    /**
     * スレッド開始.
     * infoレベル
     */
    public void thredStart() {
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        time.set(System.nanoTime());
        logger.info(
                "{} Thred START! execTime = {} [ms]",
                methodName,
                getTime());
    }

    /**
     * スレッド終了.
     * infoレベル
     */
    public void thredEnd() {
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        logger.info(
                "{} Thred END! execTime = {} [ms]",
                methodName,
                getTime());
        // スレッドローカル破棄
        time.remove();
    }

    /**
     * メソッド開始.
     * debugレベル
     */
    public void start() {
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        logger.debug(
                "{} START! execTime = {} [ms]",
                methodName,
                getTime());
    }

    /**
     * メソッド終了.
     * debugレベル
     */
    public void end() {
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        logger.debug(
                "{} END! execTime = {} [ms]",
                methodName,
                getTime());
    }

    public void info(final String message) {
        logger.info(message);
    }

    public void info(final String format, Object o) {
        logger.info(format, o);
    }

    public void info(final String format, Object... os) {
        logger.info(format, os);
    }

    public void debug(final String message) {
        logger.debug(message);
    }

    public void debug(final String format, Object o) {
        logger.debug(format, o);
    }

    public void debug(final String format, Object... os) {
        logger.debug(format, os);
    }

    public void warn(final String message) {
        logger.warn(message);
    }

    public void warn(final String format, Object o) {
        logger.warn(format, o);
    }

    public void warn(final String format, Object... os) {
        logger.warn(format, os);
    }

    public void error(final String message) {
        logger.error(message);
    }

    public void error(final String format, Object o) {
        logger.error(format, o);
    }

    public void error(final String format, Object... os) {
        logger.error(format, os);
    }

    private double getTime() {
        return (double) (System.nanoTime() - time.get()) / 1000000d;
    }
}
