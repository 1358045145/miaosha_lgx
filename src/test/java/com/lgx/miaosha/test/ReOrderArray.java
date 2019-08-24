package com.lgx.miaosha.test;

/**
 * 调整数组的位置，奇数在前，偶数在后
 */
public class ReOrderArray {


    public void reorderArray(int[] arr){
        if (arr == null || arr.length == 0)
            return;
        int p = 0;
        int q = arr.length - 1;
        while ( p < q){
            if (arr[p] % 2 == 0 && arr[q] % 2 == 1){ //偶数在前，奇数在后，交换位置
                swap(arr,p++,q--); //交换位置
                continue;
            }if (arr[p] % 2 == 1 ) {  //前面是奇数，直接跳过
                p++;
                continue;
            }
            if (arr[q] % 2 == 0){
                q--;
            }
        }
    }

    private void swap(int[] arr,int l,int r){
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,4,1,5,8,9,10};
        for (int i = 0 ; i < arr.length ; i ++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("反转后：");
        new ReOrderArray().reorderArray(arr);
        for (int i = 0 ; i < arr.length ; i ++){
            System.out.print(arr[i] + " ");
        }
    }
}
