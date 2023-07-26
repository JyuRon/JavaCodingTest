package com.example.k_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/15988
 */
public class Q11_15988 {
    static FastReader sc = new FastReader();
    static long[] result;
    static int testCase;
    static void input(){
        result = new long[1000001];
    }
    static void func(){
        result[1] = 1;
        result[2] = 2;
        result[3] = 4;

        for (int i = 4; i <= 1000000 ; i++) {
            result[i] = (result[i-3] + result[i-2] + result[i-1]) % 1000000009;
//            result[i] = (result[i-3] + result[i-2] + result[i-1]);
        }
    }

    public static void main(String[] args) {
        input();
        func();
        testCase = sc.nextInt();
        for (int i = 0; i < testCase; i++) {
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
