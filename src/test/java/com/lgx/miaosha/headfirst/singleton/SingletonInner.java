package com.lgx.miaosha.headfirst.singleton;

/**
 * 静态内部类实现线程安全的单例(可以实现延迟加载)
 */
public class SingletonInner {
    private SingletonInner(){}
    private static class Inner{
        private static final SingletonInner INSTANCE = new SingletonInner();
    }
    public static SingletonInner getInstance(){
        return Inner.INSTANCE;
    }
}
