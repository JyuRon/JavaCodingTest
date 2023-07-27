package com.example.k_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2193
 */
public class Q17_2193 {
    static FastReader sc = new FastReader();
    static int N;
    static long[][] Dy;
    static void input(){
        N = sc.nextInt();
        Dy = new long[N+1][2];
        Dy[1][0] = 0;
        Dy[1][1] = 1;

        if(N >= 2){
            Dy[2][0] = 1;
            Dy[2][1] = 0;
        }
    }
    
    static void func(){
        for (int i = 3; i <= N ; i++) {
            Dy[i][0] = Dy[i-1][1] + Dy[i-1][0];
            Dy[i][1] = Dy[i-1][0];
        }
        System.out.println(Dy[N][0] + Dy[N][1]);
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
