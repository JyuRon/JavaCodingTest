package com.example.b_Algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 재귀용법을 활용한 정렬 알고리즘
 * 리스트를 절반으로 잘라 비슷한 크기의 두 부분 리스트로 나눈다. --> 크기가 1개가 될때까지 끝까지 나눔
 * 각 부분 리스트를 재귀적으로 합병 정렬을 이용해 정렬한다.
 * 두 부분 리스트를 다시 하나의 정렬된 리스트로 합병한다.
 * 시간복잡도 : nlogn
 */
public class Section06_MergeSort {

    public List<Integer> merge(List<Integer> leftList, List<Integer> rightList){

        List<Integer> resultList = new ArrayList<>();

        int leftIdx = 0;
        int rightIdx = 0;

        while (leftIdx < leftList.size() && rightIdx < rightList.size()){
            if(leftList.get(leftIdx) < rightList.get(rightIdx)){
                resultList.add(leftList.get(leftIdx));
                leftIdx++;
            }else{
                resultList.add(rightList.get(rightIdx));
                rightIdx++;
            }
        }
        System.out.println(resultList);

        if(leftIdx < leftList.size()){
            resultList.addAll(leftList.subList(leftIdx, leftList.size()));
        }

        if(rightIdx < rightList.size()){
            resultList.addAll(rightList.subList(rightIdx, rightList.size()));
        }
        System.out.println(resultList);
        return resultList;
    }

    public List<Integer> mergeSplitFunc(List<Integer> dataList){
        if(dataList.size() <= 1){
            return dataList;
        }

        int medium = dataList.size() / 2;
        List<Integer> leftList = dataList.subList(0, medium);
        List<Integer> rightList = dataList.subList(medium, dataList.size());

        return merge(mergeSplitFunc(leftList), mergeSplitFunc(rightList));
    }



    public static void main(String[] args) {
        Section06_MergeSort mergeSort = new Section06_MergeSort();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add((int)(Math.random()*100));
        }
        System.out.println(mergeSort.mergeSplitFunc(list));
    }


}
