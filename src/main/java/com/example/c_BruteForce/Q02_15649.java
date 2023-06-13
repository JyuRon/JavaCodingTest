package com.example.c_BruteForce;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/15649
 */
public class Q02_15649 {

    static StringBuffer sb = new StringBuffer();
    static int M,N;
    static boolean[] checkNum;
    static int[] result;
    static Scanner sc = new Scanner(System.in);
    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        checkNum = new boolean[N+1];
        for (int i = 1; i < checkNum.length; i++) {
            checkNum[i] = false;
        }
        result = new int[M+1];
    }

    static void func(int k){
        if(k == M+1){
            for (int i = 1; i < M+1; i++) {
                sb.append(result[i]).append(' ');
            }

            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if(!checkNum[i]){
                result[k] = i;
                checkNum[i] = true;
                func(k+1);
                checkNum[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        input();
        func(1);
        System.out.println(sb.toString());
    }
}
