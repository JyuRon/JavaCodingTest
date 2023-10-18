package com.boj_150.a_BruteForce.Level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q03_1120 {
    static FastReader sc = new FastReader();
    static String A,B;
    static int result = 51;

    static void input(){
        A = sc.next();
        B = sc.next();
    }

    static void func(){

        int right = A.length();

        for (int i = 0; i <= B.length() -  A.length(); i++) {
           result = Math.min(result, diffCount(A, B.substring(i, right++)));
        }

        System.out.println(result);
    }

    static int diffCount(String a, String b){
        int count = 0;

        for (int i = 0; i < b.length(); i++) {
            if(a.charAt(i) != b.charAt(i)) count++;
        }

        return count;
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
