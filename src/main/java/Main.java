import java.util.Scanner;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService exe = Executors.newSingleThreadExecutor();

        Future<Integer> integer = exe.submit(getCallableInteger());
        exe.shutdown();
        System.out.println("Getting integer from callable ==> " + integer.get());
    }
    public static Callable<Integer> getCallableInteger() {
        return new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Scanner scanner = new Scanner(System.in);
                return scanner.nextInt();
            }
        };
    }
}