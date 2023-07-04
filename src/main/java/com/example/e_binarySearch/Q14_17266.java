package com.example.e_binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/17266
 */
public class Q14_17266 {

    static FastReader sc = new FastReader();
    static int N,M;
    static int[] spot;

    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        spot = new int[M];
        for (int i = 0; i < M; i++) {
            spot[i] = sc.nextInt();
        }

        Arrays.sort(spot);
    }
    static boolean valid(int height){
        int current = 0;
        for (int i = 0; i < M; i++) {
            // 첫 가로등인 경우 0 지점을 비춰야 한다
            if(i == 0){
                if(spot[i] - height > 0){
                    return false;
                }
            }else {
                // 이전 가로등과 이어지지 않거나 겹치치 않는 경우 false 를 반환한다.
                if(spot[i] - height > current){
                    return false;
                }
            }

            current = spot[i] + height;

            // 마지막 가로등인 경우 N 지점을 비춰야 한다
            if(i == M-1){
                if(current < N){
                    return false;
                }
            }
        }
        return true;
    }

    static void func(){
        int bottom = 1;
        int top = 100000;
        int result = top;

        while (bottom <= top){
            int mid = (bottom + top) / 2;

            if(valid(mid)){
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
