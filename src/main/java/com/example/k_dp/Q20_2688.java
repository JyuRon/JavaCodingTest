package com.example.k_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2688
 */
public class Q20_2688 {
    static FastReader sc = new FastReader();
    static int testCase;
    static long[][] Dy;
    static void func(){
        Dy = new long[65][10];
        for (int i = 0; i < 10; i++) {
            Dy[1][i] = 1;
        }

        for (int i = 2; i < 65; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    Dy[i][k] += Dy[i-1][j];
                }
            }
        }
    }

    public static void main(String[] args) {
        func();
        testCase = sc.nextInt();
        for (int i = 0; i < testCase; i++) {
            long ans = 0;
            int N = sc.nextInt();

            for (int j = 0; j < 10 ; j++) {
                ans += Dy[N][j];
            }
            System.out.println(ans);
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
