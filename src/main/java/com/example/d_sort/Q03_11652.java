package com.example.d_sort;

import java.util.*;

/**
 * https://www.acmicpc.net/problem/11652
 */
public class Q03_11652 {

    static Scanner sc = new Scanner(System.in);
    static int N;
    static Long result;

    static long[] nums;
    static void input() {
        N = sc.nextInt();
        nums = new long[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextLong();
        }

        Arrays.sort(nums);
    }

    public static void main(String[] args){
        int max = 1;
        int count = 1;
        Long result;
        input();
        result = nums[0];

        for (int i = 1; i < N; i++) {
            if(nums[i] == nums[i-1] ){
                count++;
            }else{
                count = 1;
            }

            // 카운트의 숫자가 최대일 경우 결과값을 변경한다.
            if(count > max){
                result = nums[i];
                max = count;
            }
        }

        System.out.println(result);
    }
}
