package com.example.l_rhsTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/22254
 */
public class Q_3rd_04_22254 {
    static FastReader sc = new FastReader();
    static int[] list;
    static int N,X;
    static void input(){
        N = sc.nextInt();
        X = sc.nextInt();

        list = new int[N+1];

        for (int i = 1; i <= N; i++) {
            list[i] = sc.nextInt();
        }
    }
    static void func(){
        int bottom = 1;
        int top = 100000;
        int result = top;


        while (bottom <= top){
            int mid = (bottom + top) / 2;
            int time = count(mid);
            if(time <= X){
                result = mid;
                top = mid -1;
            }else{
                bottom = mid + 1;
            }
        }

        System.out.println(result);
    }

    static int count(int value){
        int maxValue = 0;

        Queue<Integer> line = new PriorityQueue<>();
        for (int i = 0; i < value; i++) {
            line.add(0);
        }

        for (int i = 1; i <= N; i++) {
            int tmp = line.poll();
            tmp += list[i];
            line.add(tmp);
            maxValue = Math.max(maxValue, tmp);
        }


        return maxValue;
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
