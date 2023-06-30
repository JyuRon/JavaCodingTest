package com.example.e_binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2805
 */
public class Q03_2805 {

    static FastReader sc = new FastReader();
    static int N,M;
    static int[] woods;

    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();
        woods = new int[N];

        for (int i = 0; i < N; i++) {
            woods[i] = sc.nextInt();
        }
    }

    static boolean valid(int height){
        // 합이 21억이 넘을 수 있다.
        long sum = 0;
        for (int i = 0; i < N; i++) {
            if(woods[i] - height > 0){
                sum += woods[i] - height;
            }
        }

        return sum >= M;
    }

    static void func(){
        int MIN = 0;
        int MAX = 1000000000;
        int result = 0;

        while(MIN <= MAX){
            int mid = (MIN + MAX) / 2;

            if(valid(mid)){
                MIN = mid + 1;
                result = mid;
            }else{
                MAX = mid - 1;
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

        String next(){
            while(st == null || !st.hasMoreElements()){
                try {
                    st = new StringTokenizer(br.readLine());
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

            return st.nextToken();
        }

        int nextInt(){
            return Integer.parseInt(next());
        }

    }
}
