package com.example.l_rhsTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/22251
 */
public class Q_3rd_01_22251 {
    static FastReader sc = new FastReader();
    static int N,K,P,X;
    static int[][] num = {
            {1,1,1,0,1,1,1},
            {0,0,0,0,0,1,1},
            {0,1,1,1,1,1,0},
            {0,0,1,1,1,1,1},
            {1,0,0,1,0,1,1},
            {1,0,1,1,1,0,1},
            {1,1,1,1,1,0,1},
            {0,0,1,0,0,1,1},
            {1,1,1,1,1,1,1},
            {1,0,1,1,1,1,1}
    };

    static void input(){
        N = sc.nextInt();
        K = sc.nextInt();
        P = sc.nextInt();
        X = sc.nextInt();
    }

    static void func(){
        int result = 0;
        for (int i = 1; i <= N ; i++) {
            if(i == X) continue;

            if(count(i, X)){
                result++;
            }
        }
        System.out.println(result);
    }

    static boolean count(int i, int target){
        int count = 0;
        for (int j = 0; j < K; j++) {
            int currentNum = i % 10;
            int targetNum = target % 10;

            for (int k = 0; k < 7; k++) {
                if(num[currentNum][k] != num[targetNum][k]){
                    count++;
                }
            }

            i /= 10;
            target /= 10;
        }
        return count <= P;
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
