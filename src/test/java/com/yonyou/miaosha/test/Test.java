package com.yonyou.miaosha.test;

import java.util.concurrent.TimeUnit;

public class Test {


    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程将会休眠");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("休眠完成");
            }
        });
        t.start();


        System.out.println("main方法想要开始执行");
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main线程开始执行下面的逻辑");

    }
}
