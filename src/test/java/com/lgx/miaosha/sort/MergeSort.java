package com.lgx.miaosha.sort;

public class MergeSort {


    public void mergeSort(int[] arr){
        mergeSort(arr,0,arr.length - 1);
    }

    /**
     * 递归
     * @param arr
     * @param left
     * @param right
     */
    public void mergeSort(int[] arr,int left,int right){
        if (left >= right)
            return;
        int mid = left + ( right - left ) / 2;
        mergeSort(arr,0,mid);
        mergeSort(arr,mid + 1,right);
        merger(arr,left,mid,right);
    }

    /**
     * 合并的逻辑
     * @param arr
     * @param left
     * @param mid
     * @param right
     */
    public void merger(int[] arr,int left,int mid,int right){
        //合并的逻辑,创建新数组
       int[] newArr  = new int[right - left + 1];
       int k = 0;
       int q = mid + 1,p = left;
       while (p <= mid && q <= right){
           //两个都没有越界
           if (arr[p] < arr[q]){
               newArr[k++] = arr[p++];
           }else {
               newArr[k++] = arr[q++];
           }
       }
       while (p <= mid){
           //只有p没有越界
           newArr[k++] = arr[p++];
       }
        while (q <= right){
            //只有q没有越界
            newArr[k++] = arr[q++];
        }
       //将新数组中的数返回重新返回给老数组
        for (int j = 0 ; j < newArr.length ; j++){
            arr[j + left] = newArr[j];
        }
    }

    public void swap(int[] arr,int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,43,2,5,6,24,1};
        new MergeSort().mergeSort(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
