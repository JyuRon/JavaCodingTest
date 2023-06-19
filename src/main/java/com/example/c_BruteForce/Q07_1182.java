package com.example.c_BruteForce;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/1182
 * 부분 수열 : 수열의 일부항을 선택해서 원래 순서대로 나열 ===> (3,1) (1,3) 동일
 * 진 부분 수열 : 아무것도 선택되지 않은 수열을 제왼한 나머지 부분 수열
 */

public class Q07_1182 {

    static Scanner sc = new Scanner(System.in);

    static int N, M;
    static int count=0;
    static int[] nums;

    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
    }

    static void func(int depth, int result){
        if (depth == N){
            if(result == M){
                count++;
            }
            return;
        }

        func(depth+1, result + nums[depth]);
        func(depth+1, result);


    }

    public static void main(String[] args) {
        input();
        func(0,0);

        if(M == 0){
            count--;
        }
        System.out.println(count);
    }
}
