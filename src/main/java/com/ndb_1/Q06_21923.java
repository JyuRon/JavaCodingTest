package com.ndb_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/21923
 */
public class Q06_21923 {
    static FastReader sc = new FastReader();
    static int N, M;
    static int[][] graph, DyUp, DyDown;
    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        graph = new int[N][M];
        DyUp = new int[N][M];
        DyDown = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
    }

    static void func(){
        // 초기값 세팅
        DyUp[N-1][0] = graph[N-1][0];
        DyDown[N-1][M-1] = graph[N-1][M-1];

        // N-1 층 초기값 세팅
        for (int i = N-2; i >= 0 ; i--) {
            DyUp[i][0] = DyUp[i+1][0] + graph[i][0];
            DyDown[i][M-1] = DyDown[i+1][M-1] + graph[i][M-1];
        }


        // 상승 경로 : 맨 좌측 초기값 세팅
        for (int i = 1; i < M; i++) {
            DyUp[N-1][i] = DyUp[N-1][i-1] + graph[N-1][i];
        }


        // 하강 경로 : 맨 우측 초기값 세팅
        for (int i = M-2; i >= 0; i--) {
            DyDown[N-1][i] = DyDown[N-1][i+1] + graph[N-1][i];
        }

        // 상승 경로 dp
        for (int i = N-2 ; i >= 0 ; i--) {
            for (int j = 1; j < M ; j++) {
                DyUp[i][j] = Math.max(DyUp[i+1][j], DyUp[i][j-1])  + graph[i][j];
            }
        }


        // 하강 경로 dp
        for (int i = N-2; i >= 0 ; i--) {
            for (int j = M-2; j >= 0 ; j--) {
                DyDown[i][j] = Math.max(DyDown[i+1][j], DyDown[i][j+1])  + graph[i][j];
            }
        }

        long ans = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                ans = Math.max(DyUp[i][j] + DyDown[i][j], ans);
            }
        }

        System.out.println(ans);
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
