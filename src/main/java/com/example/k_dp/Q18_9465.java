package com.example.k_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/9465
 */
public class Q18_9465 {
    static FastReader sc = new FastReader();
    static int testCase, N;
    static int[][] Dy, value;
    static void input(){
        N = sc.nextInt();
        Dy = new int[N+1][2];
        value = new int[N+1][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 1; j <= N ; j++) {
                value[j][i] = sc.nextInt();
            }
        }


        Dy[1][0] = value[1][0];
        Dy[1][1] = value[1][1];

        if(N >= 2){
            Dy[2][0] = value[2][0] + value[1][1];
            Dy[2][1] = value[2][1] + value[1][0];
        }
    }
    static void func(){
        for (int i = 3; i <= N ; i++) {
            Dy[i][0] = Math.max(Dy[i-1][1], Math.max(Dy[i-2][0], Dy[i-2][1])) + value[i][0];
            Dy[i][1] = Math.max(Dy[i-1][0], Math.max(Dy[i-2][0], Dy[i-2][1])) + value[i][1];
        }

        System.out.println(Math.max(Dy[N][0], Dy[N][1]));
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
