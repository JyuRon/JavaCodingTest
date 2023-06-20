package com.example.c_BruteForce;

import java.util.Arrays;
import java.util.Scanner;

public class Q08_15663 {

    static int N, M;
    static int[] nums, selected, result;
    static Scanner sc = new Scanner(System.in);
    static StringBuffer sb = new StringBuffer();

    static void input(){

        N = sc.nextInt();
        M = sc.nextInt();
        nums = new int[N];
        selected = new int[N];
        result = new int[M];

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);
    }


    static void func(int k){
        if(k == M){
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int beforeUseCheck = 0;
        for (int i = 0; i < N; i++) {
            if(selected[i] == 1) continue;
            if(nums[i] == beforeUseCheck) continue;

            beforeUseCheck = nums[i];
            result[k] = nums[i];
            selected[i] = 1;
            func(k+1);
            selected[i] = 0;
        }

    }

    public static void main(String[] args) {
        input();
        func(0);
        System.out.println(sb.toString());
    }
}
