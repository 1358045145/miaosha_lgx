package com.lgx.miaosha.test;

/**
 * 斐波那契数列
 */
public class Fibonacci {

    public static int fibonacci(int n){
        if (n <= 1)
            return n;

        int sum = 0;
        int pre2 = 0;
        int pre1 = 1;
        for (int i = 2; i <= n ; i++){
            sum = pre2 + pre1;
            pre2 = pre1;
            pre1 = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        for (int i = 3 ; i <= 6 ; i ++)
        System.out.println(fibonacci(i));
    }
}
