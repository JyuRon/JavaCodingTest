package com.ndb_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/21921
 */
public class Q04_21921 {
    static FastReader sc = new FastReader();
    static int N, X;
    static int[] A;
    static void input(){
        N = sc.nextInt();
        X = sc.nextInt();
        A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
    }

    static void func(){
        int left = 0;
        int right = X - 1;

        int max = 0;
        int sum = 0;
        int count = 1;
        for (int i = 0; i < X; i++) {
            sum += A[i];
        }
        max = sum;

        while (right + 1 < N){
            right++;
            sum -= A[left++];
            sum += A[right];

            if(sum == max){
                count++;
            }else if(sum > max){
                max = sum;
                count = 1;
            }
        }

        if(max == 0){
            System.out.println("SAD");
        }else{
            System.out.println(max);
            System.out.println(count);
        }

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
