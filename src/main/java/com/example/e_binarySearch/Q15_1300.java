package com.example.e_binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1300
 */
public class Q15_1300 {

    static FastReader sc = new FastReader();
    static int N,K;

    static void input(){
        N = sc.nextInt();
        K = sc.nextInt();
    }

    static void func(){
        long bottom = 1;
        long top = (long) N * N;
        long result = top;

        while (bottom <= top){
            long mid = (bottom + top) / 2;

            long sum = 0;
            for (int i = 1; i <= N; i++) {
                sum += Math.min(N, mid/i);
            }

            if(sum >= K){
                top = mid - 1;
                result = mid;
            }else{
                bottom = mid + 1;
            }
        }

        System.out.println(result);
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
