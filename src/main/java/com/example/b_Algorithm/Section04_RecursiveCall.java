package com.example.b_Algorithm;

import java.util.List;

/**
 * 문제 1. 팩토리얼 결과값을 재귀호출로 구현
 * 문제 2. 숫자가 들어 있는 배열이 주어졌을 때, 배열의 합을 리턴하는 코드를 작성해보세요 (재귀용법을 써보세요)
 * 문제 3. ? + ? + ? = 4 만족하는 조합의 수를 구하시오. ?는 1,2,3 이 들어가며 ? 의 개수는 0개부터 시작하며 제한이 없음
 */
public class Section04_RecursiveCall {

    public int factorial(int num){
        if(num == 1){
            return num;
        }
        return factorial(num-1) * num;
    }

    public int arrayMultiply(List<Integer> dataList){
        if(dataList.size() == 1){
            return dataList.get(0);
        }
        return dataList.get(0) * arrayMultiply(dataList.subList(1,dataList.size()));
    }

    public int combination(int num){
        if(num == 1){
            return 1;
        }else if(num == 2){
            return 2;
        }else if(num == 4){
            return 4;
        }

        return combination(num -1) + combination(num -2) + combination(num - 3);
    }

    public static void main(String[] args) {
        Section04_RecursiveCall recursiveCall = new Section04_RecursiveCall();

        System.out.println(recursiveCall.factorial(3));
        System.out.println(recursiveCall.arrayMultiply(List.of(1,2,3,4)));
        recursiveCall.combination(4);
    }
}

