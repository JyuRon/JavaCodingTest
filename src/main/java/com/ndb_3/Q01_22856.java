package com.ndb_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/22856
 */
public class Q01_22856 {
    static FastReader sc = new FastReader();
    static int N, visitedCount, result;
    static List<Integer>[] graph;

    static void input(){
        N = sc.nextInt();
        graph = new List[N+1];


        for (int i = 1; i <= N ; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            int node = sc.nextInt();
            int left = sc.nextInt();
            int right = sc.nextInt();

            graph[node].add(left);
            graph[node].add(right);
        }
    }

    static void func(){
        dfs(1);
        System.out.println(result);
    }


    static void dfs(int value){
        if(value == -1){
            return;
        }

        if(graph[value].get(0) != -1){
            result++;
            dfs(graph[value].get(0));
            if(visitedCount != N){
                result++;
            }
        }

        visitedCount++;


        if(graph[value].get(1) != -1){
            result++;
            dfs(graph[value].get(1));

            if(visitedCount != N){
                result++;
            }

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
