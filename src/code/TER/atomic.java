package code.TER;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * this example is based off of the tutorial found here
 * https://www.youtube.com/watch?v=IQSbIOKhC4g
 */

public class atomic {
    private volatile int val = 0;
    private int MAX = 30;


    public void playPingPong() {
        Thread t1 = new Thread(new runnableEx());
        Thread t2 = new Thread(new runnableEx());
        Thread t3 = new Thread(new runnableEx());

        new Thread(() -> {
            for (int lv = val; lv < MAX; )
                if(lv != val) {
                    System.out.println("pong(" + val + ")");
                    lv = val;
                }
        }).start();

        new Thread(() -> {
            for (int lv = val; lv < MAX; ) {
                val = ++lv;
                System.out.println("ping(" + lv + ")");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }).start();

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.execute(t1::start);
        executorService.execute(t2::start);
        executorService.execute(t3::start);






    }

}