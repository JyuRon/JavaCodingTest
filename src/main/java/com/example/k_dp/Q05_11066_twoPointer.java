package com.example.k_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11066
 */
public class Q05_11066_twoPointer {
    static FastReader sc = new FastReader();
    static int testCase, N;
    static int[] A;
    static int[][] Dy, sum;
    static void input(){
        N = sc.nextInt();
        A = new int[N+1];
        for (int i = 1; i <= N ; i++) {
            A[i] = sc.nextInt();
        }

        Dy = new int[N+1][N+1];
        sum = new int[N+1][N+1];
    }


    static void func(){

        // sum[i][j] : i번쨰 부터 j 번째 까지의 합
        for (int i = 1; i <= N ; i++) {
            for (int j = i; j <= N ; j++) {
                sum[i][j] = sum[i][j-1] + A[j];
            }
        }


        /**
         * 채워야 하는 순서
         * 12 23 34
         * 13 24
         * 14
         */

        // Dy[i][j] 중 j의 시작 번호를 반복
        for (int i = 2; i <= N ; i++) {
            for (int j = i; j <=N ; j++) {
                Dy[j-i+1][j] = Integer.MAX_VALUE;

                for (int k = j-i+1; k < j ; k++) {
                    // Dy[i][j] 가 존재하는 경우 Dy[i][k] 까지의 최소값과 Dy[k+1][j] 까지의 최소값을 구한다.
                    Dy[j-i+1][j] = Math.min(Dy[j-i+1][k] + Dy[k+1][j] + sum[j-i+1][j], Dy[j-i+1][j]);
                }
            }
        }

        System.out.println(Dy[1][N]);
    }

    public static void main(String[] args) {
        testCase = sc.nextInt();
        for (int i = 0; i < testCase; i++) {
            input();
            func();
        }
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
