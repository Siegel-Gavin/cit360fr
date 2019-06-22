package code.TER;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * code based off of the tutorial
 * https://www.youtube.com/watch?v=IQSbIOKhC4g
 */

public class atomic {
    private volatile int val = 0;
    private int MAX = 30;


    public void newCode() {
        Thread n1 = new Thread(new runnableEx());
        Thread n2 = new Thread(new runnableEx());
        Thread n3 = new Thread(new runnableEx());

        new Thread(() -> {
            for (int lv = val; lv < MAX; )
                if(lv != val) {
                    System.out.println("send(" + val + ")");
                    lv = val;
                }
        }).start();

        new Thread(() -> {
            for (int lv = val; lv < MAX; ) {
                val = ++lv;
                System.out.println("recieve(" + lv + ")");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }).start();

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.execute(n1::start);
        executorService.execute(n2::start);
        executorService.execute(n3::start);






    }

}