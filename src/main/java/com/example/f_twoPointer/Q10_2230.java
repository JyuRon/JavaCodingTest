package com.example.f_twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2230
 */
public class Q10_2230 {
    static FastReader sc = new FastReader();
    static int N,M;
    static int[] nums;
    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
    }

    static void func(){
        int left = 0;
        int right = 1;
        int result = Integer.MAX_VALUE;

        while (right < N){

           if(nums[right] - nums[left] < M){
               right++;
           }else{
               result = Math.min(result, nums[right] - nums[left]);
               left++;
               if(left == right){
                   right++;
               }
           }
        }

        System.out.println(result);
    }

    public static void main(String[] args) {
        input();
        func();
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        public String next(){
            try{
                while (st == null || !st.hasMoreElements()){
                    st = new StringTokenizer(br.readLine());
                }
            }catch (IOException e){
                e.printStackTrace();
            }
            return st.nextToken();
        }
        public int nextInt(){
            return Integer.parseInt(next());
        }
    }
}
