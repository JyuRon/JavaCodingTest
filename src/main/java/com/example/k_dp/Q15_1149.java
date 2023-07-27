package com.example.k_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1149
 */
public class Q15_1149 {
    static FastReader sc = new FastReader();
    static int N;
    static int[][] value, Dy;
    static void input(){
        N = sc.nextInt();
        value = new int[N+1][3];
        Dy = new int[N+1][3];

        for (int i = 1; i <= N ; i++) {
            for (int j = 0; j < 3; j++) {
                value[i][j] = sc.nextInt();
            }
        }
    }
    static void func(){
        Dy[1][0] = value[1][0];
        Dy[1][1] = value[1][1];
        Dy[1][2] = value[1][2];

        for (int i = 2; i <= N ; i++) {
            Dy[i][0] = Math.min(Dy[i-1][1], Dy[i-1][2]) + value[i][0];
            Dy[i][1] = Math.min(Dy[i-1][0], Dy[i-1][2]) + value[i][1];
            Dy[i][2] = Math.min(Dy[i-1][0], Dy[i-1][1]) + value[i][2];
        }

        System.out.println(Math.min(Math.min(Dy[N][0],Dy[N][1]),Dy[N][2]));

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
