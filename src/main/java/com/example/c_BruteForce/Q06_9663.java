package com.example.c_BruteForce;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/9663
 */
public class Q06_9663 {

    static int N;
    static int count = 0;
    static int[] result;
    static Scanner sc = new Scanner(System.in);

    static void input(){
        N = sc.nextInt();
        result = new int[N];
    }

    static boolean isAvailable(int currentRow, int currentCol){
        for (int i = 0; i < currentRow; i++) {
            // 동일한 열에 존재하는 경우
            if(currentCol == result[i]){
                return false;
            }

            // 대각선에 존재하는 경우
            if(Math.abs(currentCol - result[i]) == (currentRow - i)){
                return false;
            }
        }
        return true;
    }

    static void func(int n){
        if(n == N){
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if(isAvailable(n, i)){
                result[n] = i;
                func(n+1);
            }
        }

    }
    public static void main(String[] args) {
        input();
        func(0);
        System.out.println(count);
    }
}
