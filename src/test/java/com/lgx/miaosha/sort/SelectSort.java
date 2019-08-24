package com.lgx.miaosha.sort;

/**
 * 选择排序
 */
public class SelectSort {

    public void selectSort(int[] arr){
        for (int i = 0 ; i < arr.length ; i++){
            int minIndex = i;
            for (int j = i + 1 ; j < arr.length ; j ++){
                if ( arr[j] < arr[minIndex] )
                    minIndex = j;
            }
           swap(arr,i,minIndex);
        }
    }


    public void swap(int[] arr,int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,43,2,5,6,24,1};
        new SelectSort().selectSort(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
