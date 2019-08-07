package com.yonyou.miaosha.test;

public class Test {

    public static void main(String[] args) {
        String s1 = new String("aaa");
        String s2 = new String("aaa");
        String s3 = s1.intern();
        String s4 = s2.intern();
        String s5 = s1.intern();  //intern()方法返回的是该字面量的引用


        System.out.println(s2 == s1);
        System.out.println(s3 == s4);
        System.out.println(s3 == s5);
    }
}
