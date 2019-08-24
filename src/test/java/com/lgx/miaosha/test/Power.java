package com.lgx.miaosha.test;

/**
 * 数值的整数此方
 */
public class Power {

    public double getPower(double base,int exponent){
        //考虑到底数是正数和负数的情况，还有是0的情况
        double pow = 0.0;
        if (base == 0){
            return 0;
        }
        //如果是正数的情况直接
        if (exponent >= 0){
            pow = power(base,exponent);
        }else {
            exponent = -(exponent);
            pow = 1.0 / power(base,exponent);
        }
        return pow;
    }

    private double power(double base,int exponent){
        if (exponent == 1)
            return base;
        if (exponent == 0)
            return 1;
        double power = 1;
        for (int i = 1 ; i <= exponent ; i ++){
            power *= base;
        }
        return power;
    }

    public static void main(String[] args) {
        System.out.println(new Power().power(2, 5));
    }
}
