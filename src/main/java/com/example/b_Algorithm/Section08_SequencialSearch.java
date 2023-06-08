package com.example.b_Algorithm;

import java.util.List;

/**
 * 순차 탐색
 * 시간복잡도 : n
 */
public class Section08_SequencialSearch {

    public Integer search(List<Integer> dataList, int num){
        for(Integer data : dataList){
            if(data == num){
                return data;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Section08_SequencialSearch sequencialSearch = new Section08_SequencialSearch();
        List<Integer> list = List.of(99);
        System.out.println(sequencialSearch.search(list, 99));
        System.out.println(sequencialSearch.search(list, 2));
    }
}
