package com.example.f_twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11728
 */
public class Q09_11728 {
    static FastReader sc = new FastReader();
    static StringBuffer sb = new StringBuffer();
    static int N,M;
    static int[] A,B;

    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();

        A = new int[N];
        B = new int[M];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);

        for (int i = 0; i < M; i++) {
            B[i] = sc.nextInt();
        }
        Arrays.sort(B);
    }

    static void func(){
        int aPointer = 0;
        int bPointer = 0;

        while (aPointer < N && bPointer < M){
            if(A[aPointer] < B[bPointer]){
                sb.append(A[aPointer]).append(" ");
                aPointer++;
            }else{
                sb.append(B[bPointer]).append(" ");
                bPointer++;
            }
        }

        if(aPointer != N){
            for (int i = aPointer; i < N; i++) {
                sb.append(A[i]).append(" ");
            }
        }else{
            for (int i = bPointer; i < M; i++) {
                sb.append(B[i]).append(" ");
            }
        }

        System.out.println(sb.toString());

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
