package com.lgx.miaosha.test;

/**
 * 求旋转数组的最小值
 */
public class MinNumberInRotateArray {

    public int getMinNumberInRotateArray(int[] arr){
        int p = 0;
        int q = arr.length - 1;
        while (p < q){
            int mid = p + ( q - p ) / 2;
            if (arr[p] == arr[mid] && arr[mid] == arr[q]){
                return getMin(arr,p,q);
            }
            if (arr[mid] > arr[q]){  //中间值还在左半部分的区间内，所以最小值在mid + 1 - q 的区间里面
                p = mid + 1;
            }else {
                q = mid ;
            }
        }
        return arr[p];
    }

    private int getMin(int[] arr,int l ,int r){
        int min = 0;
        for (int i = l ; i < r ; i ++){
            if (arr[i] > arr[i + 1]){
                return arr[i + 1];
            }
        }
        return arr[l];
    }

    public static void main(String[] args) {
        MinNumberInRotateArray number = new MinNumberInRotateArray();
        System.out.println(number.getMinNumberInRotateArray(new int[]{1, 1, 1, 0, 1}));
    }
}
