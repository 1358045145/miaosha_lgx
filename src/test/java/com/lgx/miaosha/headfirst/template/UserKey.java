package com.lgx.miaosha.headfirst.template;

public class UserKey extends BasePrefix{


    private UserKey(String prefix) {
        super(prefix);
    }

    public static String getById = new UserKey("id").getPrefix() ;

    public static String getByName = new UserKey("name").getPrefix();


    public static void main(String[] args) {
        System.out.println(UserKey.getById);
    }
}
