package com.example.b_Algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 시간복잡도 : nlogn
 * 기준점(pivot 이라고 부름)을 정해서, 기준점보다 작은 데이터는 왼쪽(left), 큰 데이터는 오른쪽(right) 으로 모으는 함수를 작성함
 * 각 왼쪽(left), 오른쪽(right)은 재귀용법을 사용해서 다시 동일 함수를 호출하여 위 작업을 반복함
 * 함수는 왼쪽(left) + 기준점(pivot) + 오른쪽(right) 을 리턴함
 */
public class Section07_QuickSort {

    // 기준점이 가운데로 생각하고 구현한 코드
    public List<Integer> sortByMediumPivot(List<Integer> dataList){
        if(dataList.size() <= 1){
            return dataList;
        }

        int medium = dataList.size() / 2;
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        for (int i = 0; i < dataList.size(); i++) {
            if(i==medium){

            }else if(dataList.get(medium) > dataList.get(i)) {
                leftList.add(dataList.get(i));
            }else{
                rightList.add(dataList.get(i));
            }
        }

        List<Integer> result = new ArrayList<>();
        result.addAll(sortByMediumPivot(leftList));
        result.add(dataList.get(medium));
        result.addAll(sortByMediumPivot(rightList));


        return result;
    }

    // 기준점을 맨 처음으로 잡을 경우
    public List<Integer> sortByFirstPivot(List<Integer> dataList){
        if(dataList.size() <= 1){
            return dataList;
        }

        int pivot = dataList.get(0);
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        for (int i = 1; i < dataList.size(); i++) {
            if(dataList.get(i) < pivot){
                leftList.add(dataList.get(i));
            }else{
                rightList.add(dataList.get(i));
            }
        }

        List<Integer> result = new ArrayList<>();
        result.addAll(sortByFirstPivot(leftList));
        result.add(pivot);
        result.addAll(sortByFirstPivot(rightList));

        return result;
    }


    public static void main(String[] args) {
        Section07_QuickSort quickSort = new Section07_QuickSort();

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            list.add((int)(Math.random()*100));
        }

        System.out.println(list);
        System.out.println(quickSort.sortByMediumPivot(list));
        System.out.println(quickSort.sortByFirstPivot(list));

    }
}
