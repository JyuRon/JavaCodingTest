package com.example.k_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/9095
 */
public class Q25_9095 {
    static FastReader sc = new FastReader();
    static int testCase,N;
    static int[] Dy;
    static void input(){
        Dy= new int[11];

        Dy[1] = 1;
        Dy[2] = 2;
        Dy[3] = 4;

        for (int i = 4; i <= 10 ; i++) {
            Dy[i] = Dy[i-3] + Dy[i-2] + Dy[i-1];
        }
    }

    public static void main(String[] args) {
        input();
        testCase = sc.nextInt();

        for (int i = 0; i < testCase; i++) {
            System.out.println(Dy[sc.nextInt()]);
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
