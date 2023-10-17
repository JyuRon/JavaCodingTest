package com.boj_150.a_BruteForce.Level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2231
 */
public class Q01_2752 {

    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        int N = sc.nextInt();

        for (int i = 1; i <=1000000 ; i++) {
            int target = i;
            int sum = 0;
            while (target != 0){
                sum += target % 10;
                target /= 10;
            }

            if(sum + i == N){
                System.out.println(i);
                return;
            }
        }

        System.out.println(0);
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
