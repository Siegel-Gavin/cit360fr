package code.TER;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * code based off of the tutorial
 * https://examples.javacodegeeks.com/core-java/util/concurrent/atomic/atomicinteger/java-atomicinteger-example/
 */

public class runnableEx implements Runnable {
    private static AtomicInteger at = new AtomicInteger(0);

    @Override
    public void run() {
        int myCounter;
        int myPrevCounter;
        int myCounterPlusFive;
        boolean isNine;
        myCounter = at.incrementAndGet();
        System.out.println("Thread " + Thread.currentThread().getId() + "  / Counter : " + myCounter);
        myPrevCounter = at.getAndIncrement();
        System.out.println("Thread " + Thread.currentThread().getId() + " / Previous : " + myPrevCounter);
        myCounterPlusFive = at.addAndGet(5);
        System.out.println("Thread " + Thread.currentThread().getId() + " / plus five : " + myCounterPlusFive);
        isNine = at.compareAndSet(9, 3);
        if (isNine) {
            System.out.println("Thread " + Thread.currentThread().getId()
                    + " / Value was equal to 9, so it was updated to " + at.intValue());

        }


    }
}