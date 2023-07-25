package com.example.k_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11726
 */
public class Q02_11726 {
    static FastReader sc = new FastReader();
    static int N;
    static int[] result;

    static void input(){
        N = sc.nextInt();
        result = new int[1005];
    }

    static void func(){
        result[1] = 1;
        result[2] = 2;

        for (int i = 3; i <= N ; i++) {
            result[i] = (result[i-2] + result[i-1]) % 10007;
        }

        System.out.println(result[N] % 10007);
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
