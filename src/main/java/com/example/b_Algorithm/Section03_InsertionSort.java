package com.example.b_Algorithm;

import org.springframework.expression.spel.ast.Literal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 삽입 정렬은 두 번째 인덱스부터 시작 (One-Base)
 * 해당 인덱스(key 값) 앞에 있는 데이터(B)부터 비교해서 key 값이 더 작으면, B값을 뒤 인덱스로 복사
 * 이를 key 값이 더 큰 데이터를 만날때까지 반복, 그리고 큰 데이터를 만난 위치 바로 뒤에 key 값을 이동
 */
public class Section03_InsertionSort {

    public List<Integer> sort(List<Integer> dataList){
        for (int i = 0; i < dataList.size() - 1; i++) {
            for (int j = i+1; j > 0 ; j--) {
                if(dataList.get(j-1) > dataList.get(j)){
                    Collections.swap(dataList, j-1, j);
                }else{
                    break;
                }
            }
        }

        return dataList;
    }


    public static void main(String[] args) {
        Section03_InsertionSort insertionSort = new Section03_InsertionSort();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add((int) (Math.random() * 100));
        }

        System.out.println(list);
        System.out.println(insertionSort.sort(list));
    }
}
