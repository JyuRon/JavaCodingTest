package com.example.f_twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1253
 */
public class Q04_1253 {

    static FastReader sc = new FastReader();
    static int N;
    static int[] A;

    static void input(){
        N = sc.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        Arrays.sort(A);
    }

    static void func(){
        int count = 0;
        for (int i = 0; i < N; i++) {
            int left = 0;
            int right = N-1;

            while (left < right){

                if(left == i){
                    left++;
                }else if(right == i){
                    right--;
                }else{
                    int tmp = A[left] + A[right];

                    if(A[i] < tmp){
                        right--;
                    }else if(A[i] > tmp) {
                        left++;
                    }else{
                        count++;
                        break;
                    }
                }
            }
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
