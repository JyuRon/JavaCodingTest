package com.example.k_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2156
 */
public class Q16_2156 {
    static FastReader sc = new FastReader();
    static int N, ans;
    static int[] value;
    static int[] Dy;
    static void input(){
        N = sc.nextInt();
        value = new int[N+1];
        Dy = new int[N+1];

        for (int i = 1; i <= N ; i++) {
            value[i] = sc.nextInt();
        }

        Dy[1] = value[1];

        if(N >= 2){
           Dy[2] = value[1] + value[2];
        }
    }

    static void func(){

        for (int i = 3; i <= N ; i++) {
            Dy[i] = Math.max(
                            // 먹지 않은 경우
                            Dy[i-1],
                    Math.max(
                            // 연속적으로 첫번째로 먹는 경우
                            Dy[i-2] + value[i],
                            // 연속적으로 두번째 먹는 경우
                            Dy[i-3] + value[i-1] + value[i])

            );
        }
        System.out.println(Dy[N]);
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
