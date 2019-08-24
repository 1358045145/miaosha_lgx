package com.lgx.miaosha.sort;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 获取数据流的中位数
 */
public class GetMid {
    //维护一个大根堆和一个小根堆
    PriorityQueue<Integer> maxHeap = new PriorityQueue(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    PriorityQueue<Integer> minHeap = new PriorityQueue();
    int size = 0;
    public void insert(Integer num){
        if (size % 2 == 0){ //总数是偶数，将新加入的结点插入到小根堆中
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        }else {
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        }
        size++;
    }

    public double getMid(){
        if (size % 2 == 0){
            return (double) (minHeap.peek() + maxHeap.peek()) / 2.0;
        }else {
            return (double)minHeap.peek();
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,32,3,1,5,33,55,0,11};
        GetMid getMid = new GetMid();
        for (int i : arr) {
            getMid.insert(i);
        }
        System.out.println(getMid.getMid());
    }
}
