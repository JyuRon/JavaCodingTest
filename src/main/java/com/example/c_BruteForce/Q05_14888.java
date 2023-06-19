package com.example.c_BruteForce;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/14888
 */
public class Q05_14888 {

    static StringBuffer sb = new StringBuffer();
    static Scanner sc = new Scanner(System.in);

    static int N;
    static int[] M;
    static int[] operation = new int[4];
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    static void input(){
        N = sc.nextInt();
        M = new int[N];

        for (int i = 0; i < N; i++) {
            M[i] = sc.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            operation[i] = sc.nextInt();
        }
    }

    static int calc(int operand1, int operator, int operand2){
        if(operator == 0){
            return operand1 + operand2;
        }else if(operator == 1){
            return operand1 - operand2;
        }else if(operator == 2){
            return operand1 * operand2;
        }else{
            return operand1 / operand2;
        }
    }
    static void func(int n, int result){
        if(n == N){
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }


        for (int i = 0; i < 4; i++) {
            if(operation[i] != 0){
                operation[i]--;
                func(n+1, calc(result, i, M[n]));
                operation[i]++;
            }


        }

    }

    public static void main(String[] args) {
        input();
        func(1, M[0]);
        sb.append(max).append("\n").append(min);
        System.out.println(sb.toString());
    }
}
