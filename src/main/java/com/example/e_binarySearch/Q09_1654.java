package com.example.e_binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1654
 */
public class Q09_1654 {

    static FastReader sc = new FastReader();
    static int[] lines;
    static int K, N;

    static void input() {
        K = sc.nextInt();
        N = sc.nextInt();
        lines = new int[K];

        for (int i = 0; i < K; i++) {
            lines[i] = sc.nextInt();
        }
    }

    static long func() {
        long bottom = 1;
        long top = Integer.MAX_VALUE;
        long result = 1;

        while (bottom <= top){
            long mid = (bottom + top) / 2;
            int count = 0;
            for (int i = 0; i < K; i++) {
                count += lines[i] / mid;
            }

            if(N <= count){
                if(result < mid){
                    result = mid;
                }
                bottom = mid + 1;
            }else{
                top = mid -1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        input();
        System.out.println(func());
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
