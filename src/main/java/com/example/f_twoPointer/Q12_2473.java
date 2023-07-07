package com.example.f_twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2473
 */
public class Q12_2473 {
    static FastReader sc = new FastReader();
    static StringBuffer sb = new StringBuffer();
    static int N;
    static int[] nums;
    static void input(){
        N = sc.nextInt();
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
    }

    static void func(){
        long result = Long.MAX_VALUE;
        int[] printValue = new int[3];

        for (int i = 0; i < N-2; i++) {
            int left = i+1;
            int right = N-1;

            while (left < right){
                long tmp = (long)nums[i] + nums[left] + nums[right];
                if(Math.abs(tmp) < result){
                    result = Math.abs(tmp);
                    printValue[0] = nums[i];
                    printValue[1] = nums[left];
                    printValue[2] = nums[right];
                }

                if(tmp > 0){
                    right--;
                }else{
                    left++;
                }
            }
        }

        System.out.println(printValue[0] + " " + printValue[1] + " " + printValue[2]);
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
