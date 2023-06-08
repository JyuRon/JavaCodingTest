package com.example.b_Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Bubble Sort : idx, idx+1 과 비교하여 큰 값을 오른쪽으로 밀어 넣는다.
 * 시간복잡도 : n^2
 */
public class Section01_BubbleSort {

    public List<Integer> sort(List<Integer> dataList){

        for (int i = 0; i < dataList.size() - 1; i++) {
            boolean swap = false;

            for (int j = 0; j < dataList.size()-1- i; j++) {
                if(dataList.get(j) > dataList.get(j+1)){
                    Collections.swap(dataList, j, j+1);
                    swap = true;
                }
            }

            if(!swap) break;;
        }
        return dataList;
    }

    public static void main(String[] args) {

        Section01_BubbleSort sort = new Section01_BubbleSort();

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add((int)(Math.random() * 100));
        }

        System.out.println(sort.sort(list));
    }


}
