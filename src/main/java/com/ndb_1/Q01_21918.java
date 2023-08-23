package com.ndb_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/21918
 * 단순 구현
 */
public class Q01_21918 {
    static FastReader sc = new FastReader();
    static StringBuffer sb = new StringBuffer();
    static int N, M;
    static int[] A;
    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();

        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = sc.nextInt();
        }

        for (int i = 0; i < M; i++) {
            func(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }
    }
    static void func(int a, int b, int c){
        if(a == 1){
            A[b] = c;
        }else {
            for (int i = b; i <= c ; i++) {
                if (a == 2)
                    A[i] = (A[i] + 1) % 2;
                else if(a == 3)
                    A[i] = 0;
                else
                    A[i] = 1;
            }
        }
    }

    public static void main(String[] args) {
        input();

        for (int i = 1; i <= N ; i++) {
            sb.append(A[i]).append(" ");
        }

        System.out.println(sb.toString());
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
