package com.lgx.miaosha.test;

public class FindTwoNum {

    public boolean find(int[] arr,int[] nums){

        if (arr == null || arr.length <= 0 )
            return false;
        for (int i = 0 ; i < arr.length ; i ++){
            while (arr[i] != i){
                if (arr[i] == arr[arr[i]]){
                    nums[0] = arr[i];
                    return true;
                }
                //交换
                swap(arr,arr[i],arr[arr[i]]);
            }
        }
        return true;
    }
    private void swap(int[] arr,int p ,int q){
        int temp = arr[p];
        arr[p] = arr[q];
        arr[q] = temp;
    }

    public static void main(String[] args) {

        int[] arr = {2,0,1,5,3,4,2};
        int[] nums = new int[10];
        System.out.println(new FindTwoNum().find(arr, nums));
        System.out.println(nums[0]);
    }

}
