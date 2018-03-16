package com.bizideal.mn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
//        int[] nums = new int[]{0, 1, 2};
//        Map<Integer, Integer> lack = new HashMap<Integer, Integer>();
        CountDownLatch countDownLatch = new CountDownLatch(2);
        countDownLatch.await();
        countDownLatch.countDown();

        CyclicBarrier c = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                System.out.println("23");
            }
        });

        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    c.await();
                } catch (Exception e) {

                }
                System.out.println(1);
            }
        }).start();

        try {
            c.await();
        } catch (Exception e) {

        }
        System.out.println(2);

        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        reentrantLock.unlock();

        ReentrantReadWriteLock r = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = r.readLock();
        readLock.lock();
        readLock.unlock();
        ReentrantReadWriteLock.WriteLock writeLock = r.writeLock();
        writeLock.lock();
        writeLock.unlock();


    }
}
