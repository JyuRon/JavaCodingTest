package com.example.k_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1309
 */
public class Q19_1309 {
    static FastReader sc = new FastReader();
    static int N , mod = 9901;
    static int[][] Dy;
    static void input(){
        N = sc.nextInt();
        Dy = new int[N+1][3];
        Dy[1][0] = 1;
        Dy[1][1] = 1;
        Dy[1][2] = 1;
    }
    static void func(){
        for (int i = 2; i <= N ; i++) {
            Dy[i][0] = (Dy[i-1][0] + Dy[i-1][1] + Dy[i-1][2]) % mod;
            Dy[i][1] = (Dy[i-1][0] + Dy[i-1][2]) % mod;
            Dy[i][2] = (Dy[i-1][0] + Dy[i-1][1]) % mod;
        }

        System.out.println((Dy[N][0] + Dy[N][1] + Dy[N][2]) % mod);
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
