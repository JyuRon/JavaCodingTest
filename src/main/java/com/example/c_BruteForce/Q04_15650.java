package com.example.c_BruteForce;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/15650
 */
public class Q04_15650 {

    static Scanner sc = new Scanner(System.in);

    static StringBuffer sb = new StringBuffer();
    static int N,M;
    static int[] result;
    static boolean[] check;
    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        result = new int[M+1];
        result[0] = 0;
        check = new boolean[N+1];
    }

    static void func(int k){
        if(k == M+1){
            for (int i = 1; i < result.length; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = result[k-1] + 1 ; i <= N ; i++) {
            if(!check[i]){
                result[k] = i;
                check[i] = true;
                func(k+1);
                check[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        input();
        func(1);
        System.out.println(sb.toString());
    }
}
