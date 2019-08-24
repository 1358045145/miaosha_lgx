package com.lgx.miaosha.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 求N个数字中最小的K个数
 */
public class GetLeastNumbers {


    public ArrayList<Integer> getLeastNumbers(int[] arr,int k){
        PriorityQueue maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {  //维护一个大根堆
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        if (arr.length < k || k <= 0)
            return new ArrayList<>();
        for (int i : arr) {
            maxHeap.add(i);
            if (maxHeap.size() > k)
                maxHeap.poll();
        }
        return new ArrayList<>(maxHeap);
    }

    public static void main(String[] args) {

        int[] arr = new int[]{3,45,66,1,6,4,54,22};
        ArrayList<Integer> leastNumbers = new GetLeastNumbers().getLeastNumbers(arr, 3);
        for (Integer number : leastNumbers) {
            System.out.print(number + " ");
        }
    }
}
