package com.company;

import com.sun.source.doctree.ThrowsTree;

import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Uploader extends Thread{
private CountDownLatch cdl;
private final int file = 500;
private final int speed = 20;

    public Uploader(CountDownLatch cdl) {
        this.cdl = cdl;
        start();
    }

    @Override
    public synchronized void run(){
        System.out.println("Началась загрузка файла на сервер");
        try {
            sleep(file / speed *100 );
            System.out.println("Загружаем.");
            sleep(file / speed*100);
            System.out.println("Загружаем..");
            sleep(file / speed*100);
            System.out.println("Загружаем...");
            sleep(file / speed*100);
            System.out.println("Загружаем....");
            sleep(file / speed*100);
            System.out.println("Загружаем.....");
            sleep(file / speed*100);
            System.out.println("Загружаем......");
            sleep(file / speed*100);
            System.out.println("Загружаем.......");
            sleep(file / speed*100);
            System.out.println("Осталось еще чуть-чуть");
            sleep(file / speed*100);
            System.out.println("Спасибо за ожидание!");
            sleep(file / speed*100);
            System.out.println("Файл полностью загружен и доступен к скачиванию!");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cdl.countDown();
    }
}
