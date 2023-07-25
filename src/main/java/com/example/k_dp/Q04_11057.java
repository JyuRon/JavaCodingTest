package com.example.k_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11057
 */
public class Q04_11057 {
    static FastReader sc = new FastReader();
    static int N;
    static int[][] result;
    static int[] tmp;
    static void input(){
        N = sc.nextInt();
        result = new int[N+1][10];
    }

    static void func(){
        // N = 1일 때 초기값 세팅
        for (int i = 0; i < 10; i++) {
            result[1][i] = 1;
        }

        // N에 대한 시행 반복
        for (int i = 2; i <= N; i++) {
            // 이전 결과값을 참고하기 위한 반복
            for (int j = 0; j < 10; j++) {
                int indexCount = result[i-1][j];

                // 이전결과값을 참조하여 이번 결과값을 갱신하려는 반복
                for (int k = j; k < 10; k++) {
                    result[i][k] += indexCount;
                    result[i][k] %= 10007;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += result[N][i];
        }

        System.out.println(sum % 10007);

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
