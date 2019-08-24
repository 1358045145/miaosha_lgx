package com.lgx.miaosha.sort;

/**
 * 冒泡排序
 */
public class BubbleSort {


    public void swap(int[] arr,int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public void bubbleSort(int[] arr){
        for (int i = 0 ; i < arr.length - 1 ; i ++){
            for (int j = 0 ; j < arr.length - 1 - i; j ++){
                if (arr[j + 1] < arr[j])
                    swap( arr,j + 1, j );
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = new int[]{3,43,2,5,6,24,1};
        new BubbleSort().bubbleSort(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
