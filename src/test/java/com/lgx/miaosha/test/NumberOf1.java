package com.lgx.miaosha.test;

/**
 *二进制数中1的个数
 */
public class NumberOf1 {

    public int numberOf1(int n){
        int count = 0;
        while (n != 0){
            count++;
            n = n & ( n - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOf1().numberOf1(-8));
    }
}
