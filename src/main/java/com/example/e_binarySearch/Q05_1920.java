package com.example.e_binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1920
 */
public class Q05_1920 {

    static int N,M;
    static int[] A;
    static int[] B;
    static FastReader sc = new FastReader();
    static StringBuffer sb = new StringBuffer();

    static void input(){
        N = sc.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);


        M = sc.nextInt();
        B = new int[M];
        for (int i = 0; i < M; i++) {
            B[i] = sc.nextInt();
        }
    }


    static void func(){
        for(int target : B){
            int bottom = 0, top = N-1;
            int result = 0;
            while (bottom <= top){
                int mid = (bottom + top) / 2;
                if(target == A[mid]){
                    result = 1;
                    break;
                }else if(target > A[mid]){
                    bottom = mid + 1;
                }else{
                    top = mid -1;
                }
            }
            sb.append(result).append("\n");
        }
    }


    public static void main(String[] args) {
        input();
        func();
        System.out.println(sb.toString());
    }

    static class C1920{
        int num;
        int originOrder;
        int result;
    }


    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next(){
            while (st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }

            return st.nextToken();
        }

        public int nextInt(){
            return Integer.parseInt(next());
        }
    }
}
