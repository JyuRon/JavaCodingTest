package com.example.k_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/15990
 */
public class Q26_15990 {
    static FastReader sc = new FastReader();
    static long[][] Dy;
    static int testCase, mod = 1000000009;
    static void input(){
        Dy = new long[100001][3];

        Dy[1][0] = 1;
        Dy[2][1] = 1;

        Dy[3][0] = 1;
        Dy[3][1] = 1;
        Dy[3][2] = 1;

        for (int i = 4; i < 100001; i++) {
            Dy[i][0] += (Dy[i-1][1] + Dy[i-1][2]) % mod;
            Dy[i][1] += (Dy[i-2][0] + Dy[i-2][2]) % mod;
            Dy[i][2] += (Dy[i-3][0] + Dy[i-3][1]) % mod;
        }
    }
    static long func(int value){
        return (Dy[value][0] + Dy[value][1] + Dy[value][2]) % mod;
    }

    public static void main(String[] args) {
        input();
        testCase = sc.nextInt();
        for (int i = 0; i < testCase; i++) {
            System.out.println(func(sc.nextInt()));
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
