import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class HelloCyclicBarrier {
    public static void main(String[] args) throws InterruptedException {

        AtomicInteger result = new AtomicInteger();

        CyclicBarrier cyclicBarrier = new CyclicBarrier(1);

        Thread th = new Thread(()->{
            result.set(getValue());
            System.out.println("in sub thread, result set to "+ result.get());
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        th.start();


        System.out.println("in main thread, result is " + result.get());
    }

    private static int getValue() {
        return 1;
    }

}
