package com.example.k_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/5557
 */
public class Q23_5557 {
    static FastReader sc = new FastReader();
    static int N;
    static long[][] Dy;
    static int[] value;
    static void input(){
        N = sc.nextInt();
        value = new int[N+1];
        Dy = new long[N+1][21];

        for (int i = 1; i <= N ; i++) {
            value[i] = sc.nextInt();
        }

    }
    static void func(){
        Dy[1][value[1]] = 1;

        for (int i = 2; i < N ; i++) {
            for (int j = 0; j <= 20 ; j++) {
                int plus = j + value[i];
                int minus = j - value[i];

                if(plus >= 0 && plus <= 20){
                    Dy[i][plus] += Dy[i-1][j];
                }

                if(minus >= 0 && minus <= 20){
                    Dy[i][minus] += Dy[i-1][j];
                }
            }
        }


        System.out.println(Dy[N-1][value[N]]);
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
