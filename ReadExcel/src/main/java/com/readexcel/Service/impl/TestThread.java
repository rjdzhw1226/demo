package com.readexcel.Service.impl;

import lombok.SneakyThrows;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class TestThread  implements Runnable{

    private CountDownLatch latch;
    private int i;
    private List list;
    TestThread(CountDownLatch latch, int i, List list){
      this.latch = latch;
      this.i = i;
      this.list = list;
    }

    @SneakyThrows
    @Override
    public void run() {
      for(int a = i*10; a<(i+1)*10; a++){
        // 执行任务逻辑
        Thread.sleep(100);
      }
      latch.countDown();
    }


}
