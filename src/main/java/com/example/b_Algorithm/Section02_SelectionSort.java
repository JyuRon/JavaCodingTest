package com.example.b_Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * Selection Sort : 선택 정렬
 * 주어진 데이터 중, 최소값을 찾음
 * 해당 최소값을 데이터 맨 앞에 위치한 값과 교체함
 * 맨 앞의 위치를 뺀 나머지 데이터를 동일한 방법으로 반복함
 * 시간복잡도 : n^2
 */
public class Section02_SelectionSort {

    public List<Integer> sort(List<Integer> list){

        for (int i = 0; i < list.size() - 1; i++) {

            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if(list.get(minIndex) > list.get(j)){
                    minIndex = j;
                }
            }

            Collections.swap(list, i, minIndex);
        }

        return list;
    }

    public static void main(String[] args) {
        Section02_SelectionSort sort = new Section02_SelectionSort();

        List<Integer> list = new ArrayList<>();


        for (int i = 0; i < 20; i++) {
            list.add((int) (Math.random() * 100));
        }

        System.out.println(list);

        System.out.println(sort.sort(list));
    }
}
