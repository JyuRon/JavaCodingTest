package com.example.e_binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * https://www.acmicpc.net/problem/3273
 */
public class Q07_3273 {

    static FastReader sc = new FastReader();
    static int N, X;
    static int[] A;

    static void input(){
        N = sc.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);
        X = sc.nextInt();
    }

    static int func(){
        int result = 0;
        for (int i = 0; i < N-1; i++) {
            int bottom = i+1, top = N-1;
            int target = A[i];
            while (bottom <= top){
                int mid = (bottom + top) / 2;
                if(target + A[mid] == X){
                    result++;
                    break;
                }else if(target + A[mid] > X){
                    top = mid - 1;
                }else{
                    bottom = mid + 1;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        input();
        System.out.println(func());
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
            }catch(IOException e){
                e.printStackTrace();
            }

            return st.nextToken();
        }

        public int nextInt(){
            return Integer.parseInt(next());
        }
    }
}
