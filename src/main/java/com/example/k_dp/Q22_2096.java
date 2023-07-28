package com.example.k_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2096
 */
public class Q22_2096 {
    static FastReader sc = new FastReader();
    static int N;
    static int[][][] Dy;
    static int[][] value;
    static void input(){
        N = sc.nextInt();
        value = new int[N+1][3];
        Dy = new int[N+1][3][2];

        for (int i = 1; i <= N ; i++) {
            for (int j = 0; j < 3; j++) {
                value[i][j] = sc.nextInt();
            }
        }
    }
    static void func(){
        // 첫번째 항목에 도착하였을때 최소와 최대
        Dy[1][0][0] = value[1][0];
        Dy[1][0][1] = value[1][0];

        // 두번째 항목에 도착하였을때 최소와 최대
        Dy[1][1][0] = value[1][1];
        Dy[1][1][1] = value[1][1];

        // 세번째 항목에 도착하였을때 최소와 최대
        Dy[1][2][0] = value[1][2];
        Dy[1][2][1] = value[1][2];


        // N번째 줄 I 번쨰 항목에 대한 최소 Dy[N][I][0]
        for (int i = 2; i <= N ; i++) {
            Dy[i][0][0] = Math.min(Dy[i-1][0][0], Dy[i-1][1][0]) + value[i][0];
            Dy[i][0][1] = Math.max(Dy[i-1][0][1], Dy[i-1][1][1]) + value[i][0];

            Dy[i][1][0] = Math.min(Dy[i-1][0][0], Math.min(Dy[i-1][1][0],Dy[i-1][2][0])) + value[i][1];
            Dy[i][1][1] = Math.max(Dy[i-1][0][1], Math.max(Dy[i-1][1][1],Dy[i-1][2][1])) + value[i][1];

            Dy[i][2][0] = Math.min(Dy[i-1][1][0], Dy[i-1][2][0]) + value[i][2];
            Dy[i][2][1] = Math.max(Dy[i-1][1][1], Dy[i-1][2][1]) + value[i][2];
        }

        int max, min;
        max = Math.max(Dy[N][0][1], Math.max(Dy[N][1][1], Dy[N][2][1]));
        min = Math.min(Dy[N][0][0], Math.min(Dy[N][1][0], Dy[N][2][0]));

        System.out.println(max + " " + min);
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
