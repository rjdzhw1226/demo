package com.readexcel.Service.impl;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class test {
  private static final int RUNNER_COUNT = 10;
  public static void main(String[] args) throws InterruptedException {
    final CountDownLatch begin = new CountDownLatch(1);
    final CountDownLatch end = new CountDownLatch(RUNNER_COUNT);
    final ExecutorService exec = Executors.newFixedThreadPool(10);

    for (int i = 0; i < RUNNER_COUNT; i++) {
      final int NO = i + 1;
      Runnable run = new Runnable() {
        @Override
        public void run() {
          try {
            begin.await();
            Thread.sleep((long)(Math.random() * 10000));
            System.out.println("No." + NO + " arrived");
          } catch (InterruptedException e) {
            e.printStackTrace();
          } finally {
            end.countDown();
          }
        }
      };
      exec.submit(run);
    }

    System.out.println("Game Start ...");
    begin.countDown();
    end.await();
//        end.await(30, TimeUnit.SECONDS);
    System.out.println("Game Over.");

    exec.shutdown();
  }
}
