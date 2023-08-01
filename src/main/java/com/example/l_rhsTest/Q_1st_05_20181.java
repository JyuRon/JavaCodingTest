package com.example.l_rhsTest;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/20181
 */
public class Q_1st_05_20181 {
    static FastReader sc = new FastReader();
    static int N,K;
    static int[] value;
    static long[] Dy;
    static void input(){
        N = sc.nextInt();
        K = sc.nextInt();
        value = new int[N+1];
        Dy = new long[N+1];
        for (int i = 1; i <= N ; i++) {
            value[i] = sc.nextInt();
        }
    }

    static void func(){
        int right = 1;
        long tmp = 0;
        long leftMaxValue = 0;

        for (int i = 1; i <= N ; i++) {
            leftMaxValue = Math.max(leftMaxValue, Dy[i-1]);

            while (right <= N && tmp < K){
                tmp += value[right++];
            }

            if(tmp >= K){
                Dy[right - 1] = Math.max(leftMaxValue + tmp - K, Dy[right - 1]);
            }


            tmp -= value[i];
        }

        long ans = 0;
        for (int i = 1; i <= N ; i++) {
            ans = Math.max(ans, Dy[i]);
        }

        System.out.println(ans);

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
