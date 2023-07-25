package com.example.k_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/9095
 */
public class Q01_9095 {
    static FastReader sc = new FastReader();
    static int[] result;

    static void func(){

        result = new int[12];
        result[1] = 1;
        result[2] = 2;
        result[3] = 4;

        for (int i = 4; i <= 11 ; i++) {
            result[i] = result[i-1] + result[i-2] + result[i-3];
        }

    }

    public static void main(String[] args) {
        func();
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            System.out.println(result[sc.nextInt()]);
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
