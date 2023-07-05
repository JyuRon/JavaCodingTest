package com.example.f_twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1806
 */
public class Q01_1806_2 {

    static FastReader sc = new FastReader();
    static int N, S;
    static int[] nums;

    static void input(){
        N = sc.nextInt();
        S = sc.nextInt();

        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
    }

    static void func(){
        int right = -1;
        int sum = 0;
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {

            // 왼쪽 포인터를 오른쪽으로 한칸 이동한다.
            if(i != 0){
                sum -= nums[i-1];
            }

            while (right + 1 <= N-1 && sum < S){
                sum += nums[++right];
            }

            // 합이 기준점 이상이면 결과값을 갱신한다.
            if(sum >= S){
                result = Math.min(result, right - i + 1);
            }

        }

        if(result == Integer.MAX_VALUE) {
            result = 0;
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
