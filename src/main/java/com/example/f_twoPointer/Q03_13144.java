package com.example.f_twoPointer;

import java.util.*;
import java.io.*;

/**
 * https://www.acmicpc.net/problem/13144
 */
public class Q03_13144 {

    static FastReader sc = new FastReader();
    static int N;
    static int[] num;
    static int[] check;

    static void input(){
        N = sc.nextInt();
        num = new int[N];

        for (int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
        }

        check = new int[100001];

    }

    static void func(){
        int right = -1;
        long count = 0;

        for (int i = 0; i < N; i++) {

            while (right + 1 < N && check[num[right+1]] == 0){
                right++;
                check[num[right]]++;
            }

            count += right - i + 1;

            check[num[i]]--;
        }

        System.out.println(count);
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
                while(st == null || !st.hasMoreElements()){
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
