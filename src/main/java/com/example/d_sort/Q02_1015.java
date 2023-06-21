package com.example.d_sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/1015
 */
public class Q02_1015 {

    static int N;
    static Q1015[] nums;
    static Scanner sc = new Scanner(System.in);
    static StringBuffer sb = new StringBuffer();

    static class Q1015 implements Comparable<Q1015>{

        @Override
        public int compareTo(Q1015 q1015){
            return this.num - q1015.num;
        }

        int num;
        int order;
        int writeOrder;

    }
    static void input(){
        N = sc.nextInt();
        nums = new Q1015[N];

        for (int i = 0; i < N; i++) {
            nums[i] = new Q1015();
            nums[i].num = sc.nextInt();
            nums[i].writeOrder = i;
        }

        Arrays.sort(nums);

        for (int i = 0; i < N; i++) {
            nums[i].order = i;
        }
    }

    public static void main(String[] args) {
        input();
        Arrays.sort(nums, new Comparator<Q1015>() {
            @Override
            public int compare(Q1015 o1, Q1015 o2) {
                return o1.writeOrder - o2.writeOrder;
            }
        });

        for (int i = 0; i < N; i++) {
            sb.append(nums[i].order).append(" ");
        }

        System.out.println(sb.toString());
    }
}
