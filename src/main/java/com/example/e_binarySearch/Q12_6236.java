package com.example.e_binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/6236
 */
public class Q12_6236 {

    static FastReader sc = new FastReader();
    static int N,M;
    static int[] money;

    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        money = new int[N];
        for (int i = 0; i < N; i++) {
            money[i] = sc.nextInt();
        }
    }

    static void func(){
        int bottom = 1;
        int top = 1000000000;
        int result = top;

        // 최소 일정중 최대 금액은 일출이 가능해야 한다.
        for (int i = 0; i < N; i++) {
            bottom = Math.max(bottom, money[i]);
        }

        while (bottom <= top){
            int mid = (bottom + top) / 2;
            int cnt = 0;
            int have = 0;

            for (int i = 0; i < N; i++) {
                // 가지고 있는 돈이 부족한 경우
                if(money[i] > have){
                    cnt++;
                    have = mid - money[i];
                }else{
                    // 가지고 있는 돈이 충분한 경우
                    have -= money[i];
                }
            }

            // 인출 횟수가 너무 적으면 인출 금액을 줄여야 한다.
            if(cnt <= M){
                top = mid -1;
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
            }catch(IOException e){
                e.printStackTrace();
            }

            return st.nextToken();
        }

        public int nextInt(){
            return Integer.parseInt(next());
        }
    }
}
