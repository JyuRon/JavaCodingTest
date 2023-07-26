package com.example.k_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/10870
 */
public class Q10_10870 {
    static FastReader sc = new FastReader();
    static int N;
    static int[] result;
    static void input(){
        N = sc.nextInt();
        result = new int[21];
    }
    static void func(){
        result[0] = 0;
        result[1] = 1;

        for (int i = 2; i <= 20 ; i++) {
            result[i] = result[i-2] + result[i-1];
        }

        System.out.println(result[N]);
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
