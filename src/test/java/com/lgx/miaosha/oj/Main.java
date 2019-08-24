package com.lgx.miaosha.oj;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            ArrayList<Integer> list = new ArrayList<>();
            HashMap<String, Integer> map = new HashMap<>();
            int n = in.nextInt();   //价签的数量  每一个价签对应价格
            int m = in.nextInt();   //商品数量
            for (int i = 0 ; i < n ; i ++){
                list.add(in.nextInt());
            }
            for (int i = 0 ; i < m ; i ++){
                String content = in.next();
                if (map.containsKey(content)){
                    map.put(content,map.get(content) + 1);
                }else {
                    map.put(content,1);
                }
            }
            Collections.sort(list);
            Collection<Integer> mapList = map.values();
            ArrayList<Integer> mapListValues = new ArrayList<>(mapList);
            Collections.sort(mapListValues);
            int minValue = 0;
            int maxValue = 0;
            for (int i = 0 ; i < list.size(); i ++){
                minValue += list.get(i) * mapListValues.get(list.size() - i - 1);
                maxValue += list.get(list.size() - i - 1) * mapListValues.get(mapListValues.size() - i - 1);
            }

            System.out.println(minValue + " " + maxValue);


        }


    }



}