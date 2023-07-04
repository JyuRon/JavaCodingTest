package com.example.e_binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/13702
 */
public class Q13_13702 {

    static FastReader sc = new FastReader();
    static int N,K;
    static int[] list;

    static void input(){
        N = sc.nextInt();
        K = sc.nextInt();

        list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = sc.nextInt();
        }
    }

    static void func(){
        long bottom = 0;
        long top = Integer.MAX_VALUE;
        long result = 0;

        while (bottom <= top){
            int cnt = 0;
            long mid = (bottom + top) / 2;

            for (int i = 0; i < N; i++) {
                cnt += list[i] / mid;
            }

            if(cnt < K){
                top = mid -1;
            }else{
                bottom = mid + 1;
                result = mid;
            }
        }

        System.out.println(result);
    }

    public static void main(String[] args){
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
