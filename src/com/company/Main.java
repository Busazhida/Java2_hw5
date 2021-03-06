package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(1);
        CountDownLatch latch = new CountDownLatch(10);
        Semaphore semaphore = new Semaphore(3, true);
        new Uploader(cdl);
        for (int i = 1; i <= 10; i++) {
            new Downloaders("Загрузчик"+" "+ i+ " ", semaphore, cdl, latch);
        }
        try {
            latch.await();

            System.out.println("К сожалению файл был удален из сервера :(");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
