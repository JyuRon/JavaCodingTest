package com.example.f_twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2559
 */
public class Q07_2559 {
    static FastReader sc = new FastReader();
    static int N,K;
    static int[] nums;

    static void input(){
        N = sc.nextInt();
        K = sc.nextInt();
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
    }

    static void func(){
        int right = -1;
        int result = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < N; i++) {
            while (valid(i, right+1)){
                right++;
                sum += nums[right];
            }

            if(right - i + 1 == K){
                result = Math.max(result, sum);
            }

            sum -= nums[i];
        }

        System.out.println(result);
    }

    static boolean valid(int currentLeftIndex, int nextRightIndex){

        // 오른쪽 인덱스가 배열 길이를 초과하는 경우
        if(nextRightIndex >= N){
            return false;
        }

        // 합산하고자 하는 원소의 개수가 K개를 초과하는 경우
        if(nextRightIndex - currentLeftIndex + 1 > K){
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
