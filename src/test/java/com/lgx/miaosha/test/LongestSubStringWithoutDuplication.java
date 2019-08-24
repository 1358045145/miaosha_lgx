package com.lgx.miaosha.test;

import java.util.Arrays;
import java.util.Date;

/**
 * 最长不重复的字串的长度(双指针)
 */
public class LongestSubStringWithoutDuplication {

    public int longestSubStringWithoutDuplication(String str){
        int l = 0 ,r = -1,res = 0;
        int[] freq = new int[256];
        Arrays.fill(freq, 0);
        while ( l < str.length()){
            if (r + 1 < str.length() && freq[str.charAt(r + 1)] == 0){
                freq[str.charAt(++r)]++;
            }else {
                freq[str.charAt(l++)]--;
            }
            res = Math.max(res,r - l + 1);
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println(new LongestSubStringWithoutDuplication().longestSubStringWithoutDuplication("arabcacfr"));
    }
}
