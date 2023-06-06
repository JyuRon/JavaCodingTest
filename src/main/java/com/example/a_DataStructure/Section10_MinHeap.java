package com.example.a_DataStructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 힙의 구현은 arrayList 로 구현한다.
 * 부모 노드는 자식노드보다 작거나 같아야 한다.
 * arrayList 첫번째는 비워두고 부모 노드와 자식노드의 관계는 idx / 2 , idx / 2 +1 로 정의
 * 데이터 추가시 마지막 배열에 추가하고 부모노드와 비교하여 스압하는 과정을 반복한다.
 * 데이터 삭제시 제일 마지막 노드를 첫번째로 변경 하고 자식노드와 비교하여 가장 작은 자식노드와 스압하는 과정을 반복
 */
public class Section10_MinHeap {

    List<Integer> heapArray;

    public Section10_MinHeap(Integer data){
        this.heapArray = new ArrayList<>();
        this.heapArray.add(null);
        this.heapArray.add(data);
    }


    public boolean move_up(int insertedIdx){
        if(insertedIdx <= 1){
            return false;
        }

        int parentIdx = insertedIdx / 2;

        // 자식 노드가 부모 노드보다 작은 경우
        return this.heapArray.get(insertedIdx) < this.heapArray.get(parentIdx);
    }


    public boolean insert(Integer data){

        if(heapArray == null){
            this.heapArray = new ArrayList<>();
            this.heapArray.add(null);
            this.heapArray.add(data);
            return true;
        }

        this.heapArray.add(data);
        int insertedIdx = this.heapArray.size() - 1;
        int parentIdx;

        while (this.move_up(insertedIdx)){
            parentIdx = insertedIdx / 2;
            Collections.swap(this.heapArray, insertedIdx, parentIdx);
            insertedIdx = parentIdx;
        }

        return true;
    }

    public boolean move_down(int popIdx){

        int childLeftIdx = popIdx * 2;
        int childRightIdx = childLeftIdx + 1;

        // 자식 노드가 존재하지 않은 경우
        if(childLeftIdx >= this.heapArray.size()){
            return false;
        }

        // 왼쪽 자식 노드만 존재하는 경우
        if(childRightIdx >= this.heapArray.size()){
            return this.heapArray.get(popIdx) > this.heapArray.get(childLeftIdx);
        }

        // 자식 노드가 모두 존재하는 경우 자식노드 중 가능 작은 노드를 선택한다
        if(this.heapArray.get(childLeftIdx) > this.heapArray.get(childRightIdx)){
            return this.heapArray.get(popIdx) > this.heapArray.get(childRightIdx);
        }else {
            return this.heapArray.get(popIdx) > this.heapArray.get(childRightIdx);
        }
    }

    public Integer pop(){
        Integer result;
        int childPopLeftIndex, childPopRightIndex, popIdx;

        if(this.heapArray == null){
            return null;
        }

        // 결과값을 미리 추출하고 마지막 노드를 root 로 이동시킨 후 삭제한다.
        result = this.heapArray.get(1);
        this.heapArray.set(1, this.heapArray.get(this.heapArray.size() - 1));
        this.heapArray.remove(this.heapArray.size() - 1);


        // 루트노드를 다시 최소값으로 변경한다.
        popIdx = 1;

        while (this.move_down(popIdx)){
            childPopLeftIndex = popIdx * 2;
            childPopRightIndex = childPopLeftIndex + 1;

            // move_down 메소드에서 이미 노드가 존재하는 것을 판단
            // 즉 자식 노드의 개수에 따른 케이스만 분류하면됨

            // 왼쪽 자식노드만 존재하는 경우
            if(childPopRightIndex >= this.heapArray.size()){
                Collections.swap(this.heapArray, childPopLeftIndex, popIdx);
                popIdx = childPopLeftIndex;
            }else{
                // 자식 노드가 모두 존재하는 경우 자식노드 중 가능 작은 노드를 선택한다
                if(this.heapArray.get(childPopLeftIndex) > this.heapArray.get(childPopRightIndex)){
                    Collections.swap(this.heapArray, childPopRightIndex, popIdx);
                    popIdx = childPopRightIndex;
                }else {
                    Collections.swap(this.heapArray, childPopLeftIndex, popIdx);
                    popIdx = childPopLeftIndex;
                }
            }
        }

        return result;
    }


    public static void main(String[] args) {
        Section10_MinHeap heapTest = new Section10_MinHeap(15);
        heapTest.insert(10);
        heapTest.insert(8);
        heapTest.insert(5);
        heapTest.insert(4);
        heapTest.insert(20);
        System.out.println(heapTest.heapArray);

        heapTest.pop();
        System.out.println(heapTest.heapArray);

        heapTest.pop();
        System.out.println(heapTest.heapArray);

        heapTest.pop();
        System.out.println(heapTest.heapArray);

        heapTest.pop();
        System.out.println(heapTest.heapArray);

    }


}
