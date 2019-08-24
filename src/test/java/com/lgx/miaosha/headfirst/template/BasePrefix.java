package com.lgx.miaosha.headfirst.template;

public abstract class BasePrefix implements KeyPrefix{

    private int expire;
    private String prefix;

    public BasePrefix(String prefix){
        this(0,prefix);
    }

    public BasePrefix(int expire,String prefix){
        this.expire = expire;
        this.prefix = prefix;
    }

    @Override
    public int expireSecond() {  //0表示的无过期时间
        return expire;
    }

    @Override
    public String getPrefix() {
        String name = this.getClass().getSimpleName();
        return name + ":" + prefix;
    }
}
