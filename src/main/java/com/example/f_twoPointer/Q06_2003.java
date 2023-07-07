package com.example.f_twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2003
 */
public class Q06_2003 {
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
    }

    static void func(){
        int count = 0;
        int right = -1;
        int sum = 0;

        for (int i = 0; i < N; i++) {
            while (valid(right + 1, sum)){
                right++;
                sum += nums[right];
            }

            if(sum == M){
                count++;
            }

            // 왼쪽 포인터의 이동으로 이한 합계 차감
            sum -= nums[i];
        }

        System.out.println(count);
    }

    static boolean valid(int nextRight, int currentSum){
        if(nextRight >= N){
            return false;
        }

        if(currentSum + nums[nextRight] > M){
            return false;
        }

        return true;
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
