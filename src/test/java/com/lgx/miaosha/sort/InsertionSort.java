package com.lgx.miaosha.sort;

public class InsertionSort {

    public void insertionSort(int[] arr){
        for (int i = 1 ; i < arr.length ; i++){
            for (int j = i ; j > 0 && arr[j] < arr[j - 1]; j--){
                swap(arr,j,j - 1);
            }
        }
    }
    public void swap(int[] arr,int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{3,43,2,5,6,24,1};
        new InsertionSort().insertionSort(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }


}
