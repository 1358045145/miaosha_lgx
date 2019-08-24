package com.lgx.miaosha.test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 把数组排成最小的数
 */
public class PrintMinNumber {

    public void printMinNumber(int[] arr){
        String[] arrStr = new String[arr.length];
        for (int i = 0 ; i < arr.length ; i ++){
            arrStr[i] = arr[i] + "";
        }
        Arrays.sort(arrStr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1 + s2).compareTo((s2 + s1));
            }
        });
        String res = "";
        for (int j = 0 ; j < arrStr.length ; j ++){
            res += arrStr[j];
        }
        System.out.println(res);

    }

    public static void main(String[] args) {
        new PrintMinNumber().printMinNumber(new int[]{3,31,541});
    }
}
