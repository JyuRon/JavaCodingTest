package com.example.e_binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/10816
 */
public class Q08_10816 {

    static int N,M;
    static int[] A,B;
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

    static int findLowerIndex(int target, int bottom, int top){
        int result = N;
        while (bottom <= top){
            int mid = (bottom + top) / 2;
            if(A[mid] >= target){
                if(A[mid] == target && result > mid){
                    result = mid;
                }
                top = mid -1;
            }else{
                bottom = mid + 1;
            }
        }

        return result;
    }

    static int findUpperIndex(int target, int bottom, int top){
        int result = -1;
        while (bottom <= top){
            int mid = (bottom + top) / 2;
            if(A[mid] <= target){
                if(A[mid] == target && result < mid){
                    result = mid;
                }
                bottom = mid + 1;
            }else{
                top = mid -1;
            }
        }

        return result;
    }

    static void func(){
        for(int target : B){
            int result;
            int bottom = 0, top = N - 1;

            int lowerIndex = findLowerIndex(target, bottom, top);
            int upperIndex = findUpperIndex(target, bottom, top);


            if(upperIndex != -1 && lowerIndex != N){
                result = upperIndex - lowerIndex + 1;
            }else if(upperIndex != -1 || lowerIndex != N){
                result = 1;
            }else{
                result = 0;
            }


            sb.append(result).append(" ");
        }
    }

    public static void main(String[] args) {
        input();
        func();
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
