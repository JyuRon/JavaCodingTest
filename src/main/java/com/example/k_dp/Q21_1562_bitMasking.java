package com.example.k_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 : https://www.acmicpc.net/problem/1562
 * 풀이 : https://loosie.tistory.com/171
 * 이론 : https://loosie.tistory.com/238
 *
 */
public class Q21_1562_bitMasking {
    static FastReader sc = new FastReader();
    static long[][][] Dy;
    static int mod = 1000000000;
    static void input(){
        // 1<< 10 = 1024   ---> 9비트로 0 ~ 1023(111111111) 까지의 숫자가 표현 가능
        Dy = new long[101][10][1<<10];
        for (int i = 1; i < 10; i++) {
            Dy[1][i][1<<i] = 1;
        }

        for (int i = 2; i <= 100 ; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 1<<10; k++) {
                    if(j == 0){
                        Dy[i][j][k | (1<<j)] += Dy[i-1][j+1][k] % mod;
                    }else if(j == 9){
                        Dy[i][j][k | (1<<j)] += Dy[i-1][j-1][k] % mod;
                    }else{
                        Dy[i][j][k | (1<<j)] += Dy[i-1][j-1][k] % mod;
                        Dy[i][j][k | (1<<j)] += Dy[i-1][j+1][k] % mod;
                    }

                    Dy[i][j][k | (1<<j)] %= mod;

                }
            }
        }
    }

    static long func(int value){
        long ans = 0;
        for (int i = 0; i < 10; i++) {
            //
            ans += Dy[value][i][(1<<10) - 1] % mod;
            ans %= mod;
        }
        return ans;
    }

    public static void main(String[] args) {
        input();
        System.out.println(func(sc.nextInt()));
    }
    static class FastReader {
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

