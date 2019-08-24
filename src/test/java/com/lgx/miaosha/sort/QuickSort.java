package com.lgx.miaosha.sort;

/**
 * 快速排序
 */
public class QuickSort {


    public void partitionSort(int[] arr){

        partitionSort(arr,0,arr.length - 1);
    }
    public void partitionSort(int[] arr,int l,int r){
        if (l >= r)
            return;
        int val = arr[l];
        int less = l,j = l + 1;
        int more = r + 1;
        while (j < more){
            if (arr[j] < val){
                swap(arr,++less,j++);
            }else if (arr[j] > val) {
                swap(arr, --more, j);
            }else {
                j++;
            }
        }
        swap(arr,l,less);
        partitionSort(arr,l,less);
        partitionSort(arr,more,r);


    }



    public void swap(int[] arr,int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {4, 4, 9, 1, 4, 3, 0, 5, 8};
        new QuickSort().partitionSort(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}
