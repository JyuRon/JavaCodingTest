package com.example.k_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1495
 */
public class Q24_1495 {
    static FastReader sc = new FastReader();
    static int N,S,M;
    static boolean[][] Dy;
    static int[] value;
    static void input(){
        N = sc.nextInt();
        S = sc.nextInt();
        M = sc.nextInt();

        value = new int[N+1];
        Dy = new boolean[N+1][M+1];

        for (int i = 1; i <= N ; i++) {
            value[i] = sc.nextInt();
        }

        Dy[0][S] = true;
    }

    static void func(){
        for (int i = 1; i <= N ; i++) {
            int ableCount = 0;
            for (int j = 0; j <= M ; j++) {

                if(Dy[i-1][j]){
                    int plus = j + value[i];
                    int minus = j - value[i];

                    if(plus <= M ){
                        Dy[i][plus] = true;
                        ableCount++;
                    }

                    if(minus >= 0 ){
                        Dy[i][minus] = true;
                        ableCount++;
                    }
                }
            }

            if(ableCount == 0){
                System.out.println(-1);
                return;
            }
        }

        for (int i = M; i >= 0 ; i--) {
            if(Dy[N][i]){
                System.out.println(i);
                return;
            }
        }
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
