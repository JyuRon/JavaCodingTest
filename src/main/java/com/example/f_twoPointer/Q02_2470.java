package com.example.f_twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2470
 */
public class Q02_2470 {

    static FastReader sc = new FastReader();
    static int N;
    static int[] node;

    static void input(){
        N = sc.nextInt();
        node = new int[N];

        for (int i = 0; i < N; i++) {
            node[i] = sc.nextInt();
        }

        Arrays.sort(node);
    }

    static void func(){
        int left = 0, right = N-1;
        int leftResult = 0, rightResult = 0;
        int result = Integer.MAX_VALUE;
        while(left != right){

            int tmp = node[left] + node[right];

            if(Math.abs(tmp) < result){
                result = Math.abs(node[left] + node[right]);
                leftResult = node[left];
                rightResult = node[right];
            }

            if(tmp > 0){
                right--;
            }else{
                left++;
            }
        }

        System.out.println(leftResult + " " + rightResult);
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
