import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class HelloFixedThreadExecutor {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        AtomicInteger result = new AtomicInteger();

        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Callable th = (Callable) (()-> {
            result.set(getValue());
            System.out.println("in sub thread, result set to " + result);
            return result;
        });
        FutureTask futureTask = (FutureTask) executorService.submit(th);
        System.out.println("in main thread, result is " + futureTask.get());
    }

    private static int getValue() {
        return 1;
    }

}
