package com.example.b_Algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 동적 프로그래밍(DP) : 상향식 접근 방법으로 f(0) 부터 시작하여 f(n)을 구함, 메모라지징 방식을 사용
 * 분할 정복 : 하양식 접근 방법으로 f(n) 부터 시작하여 f(0)을 구함, 재귀호출 방식을 사용
 * 이를 피보나치 수열 f(n) = f(n-1) + f(n-2) , f(0) = 0, f(1) = 1 를 두가지 방식으로 모두 구현
 */
public class Section05_DynamicProgramingAndDivideConquer {

    public int dynamicPrograming(int num){
        List<Integer> memory = new ArrayList<>();
        memory.add(0);
        memory.add(1);

        for (int i = 2; i <= num; i++) {
            memory.add(memory.get(i-1) + memory.get(i-2));
        }

        return memory.get(num);
    }

    public int divideConquer(int num){
        if(num <= 1){
            return num;
        }
        return divideConquer(num -1) + divideConquer(num-2);
    }

    public static void main(String[] args) {
        Section05_DynamicProgramingAndDivideConquer fibonacci = new Section05_DynamicProgramingAndDivideConquer();

        System.out.println(fibonacci.dynamicPrograming(10));
        System.out.println(fibonacci.divideConquer(10));
    }
}
