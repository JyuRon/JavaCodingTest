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
    static long result;
    static void input(){
        N = sc.nextInt();
        K = sc.nextInt();
        value = new int[N+1];
        for (int i = 1; i <= N ; i++) {
            value[i] = sc.nextInt();
        }
    }

    static void func(){
        int bottom = 1;
        int top = 1;
        int count = value[1];
        int L = 1, R = 1;
        int tmp = count;

        while (bottom <= top){

            if((bottom >= L && bottom <= R) || (top >= L && top <= R) && count > tmp){

            }

            if(count > K) {
                count -= value[bottom];
                bottom++;
            }else if(top < N){
                top++;
                count += value[top];
            }
        }
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
