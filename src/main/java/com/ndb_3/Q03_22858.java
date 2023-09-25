package com.ndb_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/22858
 */
public class Q03_22858 {
    static FastReader sc = new FastReader();
    static StringBuffer sb = new StringBuffer();
    static int N,K;
    static int[] D, S, result;

    static void input(){
        N = sc.nextInt();
        K = sc.nextInt();

        D = new int[N+1];
        S = new int[N+1];
        result = new int[N+1];

        for (int i = 1; i <= N; i++) {
            S[i] = sc.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            D[i] = sc.nextInt();
        }
    }

    static void func(){

        for (int i = 1; i <= K ; i++) {

            for (int j = 1; j <= N; j++) {
                result[D[j]] = S[j];
            }

            for (int j = 1; j <= N; j++) {
                S[j] = result[j];
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb.toString());
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
