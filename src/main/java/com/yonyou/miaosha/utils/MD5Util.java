package com.yonyou.miaosha.utils;


import org.apache.commons.codec.digest.DigestUtils;

import java.util.UUID;

/**
 * md5加密工具类，两次加密
 */
public class MD5Util {

    private static final String salt = "1234aBcD";
    //md5加密
    public static String md5(String password){
       return DigestUtils.md5Hex(password);
    }
    //第一次加密
    public static String firstMd5(String password){
        String pass = salt.charAt(3) + salt.charAt(1) + password + salt.charAt(6);
        return md5(pass);
    }
    //第二次加密
    public static String secondMd5(String salt,String password){
        String pass = salt.charAt(3) + salt.charAt(1) + password + salt.charAt(6);
        return md5(pass);
    }
    //最终加密
    public static String formPassToDB(String password,String saltDb){
        String firstMd5 = firstMd5(password);
        return secondMd5(saltDb,firstMd5);
    }

//    public static void main(String[] args) {
//        System.out.println(new MD5Util().formPassToDB("123456","43fda21"));
//    }

}
