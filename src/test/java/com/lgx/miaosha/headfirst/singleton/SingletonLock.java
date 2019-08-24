package com.lgx.miaosha.headfirst.singleton;

/**
 * 线程安全的双检索机制的单例
 */
public class SingletonLock {

    private volatile static SingletonLock instance = null;  //volatile禁止指令的重排序
    private SingletonLock(){}

    public static SingletonLock getInstance(){
        if (instance == null){
            synchronized (SingletonLock.class){
                if (instance == null){             //这里再做一次判断是方式两个同时争抢的线程创建第二次实例
                    instance = new SingletonLock();
                }
            }
        }
        return instance;
    }
}
