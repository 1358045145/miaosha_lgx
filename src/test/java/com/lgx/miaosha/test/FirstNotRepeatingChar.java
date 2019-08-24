package com.lgx.miaosha.test;

/**
 * 第一个只出现一次的字符
 */
public class FirstNotRepeatingChar {

    public int first(String str){
        int[] arr = new int[256];
        for (int i = 0 ; i < str.length() ; i ++){
            arr[str.charAt(i)]++;
        }
        for (int j = 0 ; j < arr.length ; j ++){
            if (arr[str.charAt(j)] == 1){
                return j;
            }
        }


        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new FirstNotRepeatingChar().first("abacc"));
    }
}
