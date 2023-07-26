package com.example.k_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11052
 */
public class Q13_11052 {
    static FastReader sc = new FastReader();
    static int[] Dy, A;
    static int N;
    static void input(){
        N = sc.nextInt();
        Dy = new int[N+1];
        A = new int[N+1];

        for (int i = 1; i <= N ; i++) {
            A[i] = sc.nextInt();
        }
    }
    static void func(){
        Dy[1] = A[1];
        for (int i = 2; i <= N ; i++) {
            for (int j = 1; j <= i ; j++) {
                Dy[i] = Math.max(Dy[i-j] + A[j] , Dy[i]);
            }
        }

        System.out.println(Dy[N]);
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
