package com.example.k_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2579
 */
public class Q03_2579 {
    static FastReader sc = new FastReader();
    static int N;
    static int[] A;
    static int[][] result;
    static void input(){
        N = sc.nextInt();
        A = new int[N+1];
        result = new int[N+1][2];

        for (int i = 1; i <= N ; i++) {
            A[i] = sc.nextInt();
        }
    }

    static void func(){

        // +2 인 경우
        result[1][0] = 0;

        // +1 인 경우
        result[1][1] = A[1];

        if(N >= 2){
            result[2][0] = A[2];
            result[2][1] = A[1] + A[2];
        }

        for (int i = 3; i <= N ; i++) {

            // 이전 2계단 전에서 올라오는 경우( 이전 2계전 전이 2개,1개로 올라온 상태인지는 중요햐지 않다, 규칙을 지키기 때문)
            result[i][0] = Math.max(result[i-2][0] + A[i] , result[i-2][1] + A[i]);

            // 이전 계단이 +1 로 올라온 경우 규칙에 위배 되어 +2 로 올라온 상태에서만 값을 추가
            result[i][1] = result[i-1][0] + A[i];
        }

        System.out.println(Math.max(result[N][0], result[N][1]));
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
