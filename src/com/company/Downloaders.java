package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Downloaders extends Thread{
    private int downSpeed = 100;
    private Semaphore semaphore;
    private CountDownLatch cdl;
    private CountDownLatch latch;

    public Downloaders(String name, Semaphore semaphore, CountDownLatch cdl, CountDownLatch latch){
        super(name);
        this.semaphore = semaphore;
        this.cdl = cdl;
        this.latch = latch;
        start();
    }

    @Override
    public synchronized void run() {
        try {
            cdl.await();
            semaphore.acquire();
            System.out.println(getName() + "начал скачивать файл из сервера");
            sleep(500 / downSpeed*100);
            System.out.println(getName() + "Завершил скачивание файла");
            latch.countDown();
            semaphore.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
