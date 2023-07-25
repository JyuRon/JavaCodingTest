package com.example.k_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/15681
 */
public class Q06_15681 {
    static FastReader sc = new FastReader();
    static int N,R,Q;
    static ArrayList<Integer>[] graph;
    static int[] result;
    static void input(){
        N = sc.nextInt();
        R = sc.nextInt();
        Q = sc.nextInt();
        graph = new ArrayList[N+1];
        result = new int[N+1];

        for (int i = 1; i <= N ; i++) {
            graph[i] = new ArrayList<>();
            result[i] = 1;
        }

        for (int i = 0; i < N-1; i++) {
            int startNode = sc.nextInt();
            int endNode = sc.nextInt();

            graph[startNode].add(endNode);
            graph[endNode].add(startNode);
        }
    }
    static void func(){
        dfs(R,-1);
    }

    static void dfs(int value, int parent){

        for(int next : graph[value]){
            if(next == parent){
                continue;
            }
            dfs(next, value);
            result[value] += result[next];
        }
    }

    public static void main(String[] args) {
        input();
        func();

        for (int i = 0; i < Q; i++) {
            System.out.println(result[sc.nextInt()]);
        }
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
