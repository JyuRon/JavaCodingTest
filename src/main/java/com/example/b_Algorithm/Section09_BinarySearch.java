package com.example.b_Algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 시간복잡도 : logn
 */
public class Section09_BinarySearch {

    public boolean search(List<Integer> dataList, int num){

        if (dataList.size() == 1 && num == dataList.get(0)) {
            return true;
        }
        if (dataList.size() == 1 && num != dataList.get(0)) {
            return false;
        }
        if (dataList.size() == 0) {
            return false;
        }


        int medium = dataList.size() / 2;
        int pivot = dataList.get(medium);

        if(pivot == num){
            return true;
        }

        if(num < pivot){
            return search(dataList.subList(0, medium), num);
        }else{
            return search(dataList.subList(medium + 1, dataList.size()), num);
        }
    }


    public static void main(String[] args) {
        Section09_BinarySearch binarySearch = new Section09_BinarySearch();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 19; i++) {
            list.add(i);
        }

        System.out.println(binarySearch.search(list, 0));
        System.out.println(binarySearch.search(list, 19));
        System.out.println(binarySearch.search(list, 10));
        System.out.println(binarySearch.search(list, 99));
    }
}
