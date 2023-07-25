package com.example.k_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1949
 */
public class Q07_1949 {
    static FastReader sc = new FastReader();
    static int[] A;
    static int[][] result;
    static int N;
    static ArrayList<Integer>[] graph;
    static void input(){
        N = sc.nextInt();
        A = new int[N+1];
        result = new int[N+1][2];
        graph = new ArrayList[N+1];

        for (int i = 1; i <= N ; i++) {
            graph[i] = new ArrayList<>();
            A[i] = sc.nextInt();
        }

        for (int i = 0; i < N-1; i++) {
            int startNode = sc.nextInt();
            int endNode = sc.nextInt();

            graph[startNode].add(endNode);
            graph[endNode].add(startNode);
        }
    }
    static void func(){
        dfs(1,-1);
        System.out.println(Math.max(result[1][0], result[1][1]));
    }
    static void dfs(int value, int parent){
        result[value][1] = A[value];

        for(int next : graph[value]){
            if(next == parent){
                continue;
            }
            dfs(next, value);

            // 해당 마을이 우수마을이 아닌 경우
            result[value][0] += Math.max(result[next][1], result[next][0]);

            // 해당 마을이 우수마을인 경우
            result[value][1] += result[next][0];
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
