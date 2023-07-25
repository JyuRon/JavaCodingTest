package com.example.k_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1003
 */
public class Q09_1003 {
    static FastReader sc = new FastReader();
    static int testCase;
    static int[][] result;
    static void input(){
        result = new int[41][2];
    }
    static void func(){
        result[0][0] = 1;
        result[0][1] = 0;

        result[1][0] = 0;
        result[1][1] = 1;

        for (int i = 2; i <= 40 ; i++) {
            result[i][0] = result[i-2][0] + result[i-1][0];
            result[i][1] = result[i-2][1] + result[i-1][1];
        }
    }

    public static void main(String[] args) {
        input();
        func();

        testCase = sc.nextInt();

        for (int i = 0; i < testCase; i++) {
            int target = sc.nextInt();
            System.out.println(result[target][0] + " " + result[target][1]);
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
