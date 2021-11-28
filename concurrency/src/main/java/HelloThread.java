import java.util.concurrent.atomic.AtomicInteger;

public class HelloThread {
    public static void main(String[] args) throws InterruptedException {

        AtomicInteger result = new AtomicInteger();

        Thread th = new Thread(()->{
            result.set(getValue());
            System.out.println("in sub thread, result set to "+ result.get());
        });
        th.start();
        th.join();
        System.out.println("in main thread, result is " + result.get());
    }

    private static int getValue() {
        return 1;
    }

}
