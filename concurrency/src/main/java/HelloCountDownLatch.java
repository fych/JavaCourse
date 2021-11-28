import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class HelloCountDownLatch {
    public static void main(String[] args) throws InterruptedException {

        AtomicInteger result = new AtomicInteger();

        CountDownLatch countDownLatch = new CountDownLatch(1);

        Thread th = new Thread(()->{
            result.set(getValue());
            System.out.println("in sub thread, result set to "+ result.get());
            countDownLatch.countDown();
        });
        th.start();

        countDownLatch.await();
        System.out.println("in main thread, result is " + result.get());
    }

    private static int getValue() {
        return 1;
    }

}
