package com.example.h_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/14267
 */
public class Q12_14267 {
    static FastReader sc = new FastReader();
    static StringBuffer sb = new StringBuffer();
    static int N,M;
    static ArrayList<Integer>[] graph;
    static int[] result;
    static void input(){
        N = sc.nextInt();
        M = sc.nextInt();

        graph = new ArrayList[N+1];
        result = new int[N+1];


        for (int i = 1; i <=N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N ; i++) {
            int parentNode = sc.nextInt();
            if(i == 1){
                continue;
            }
            graph[parentNode].add(i);
        }

    }

    static void func() {

        for (int i = 0; i < M; i++) {
            int key = sc.nextInt();
            int value = sc.nextInt();
            result[key] = value;
        }

        dfs(1);

        for (int i = 1; i <= N ; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb.toString());
    }

    static void dfs(int value){

        for(int next : graph[value]){
            result[next] += result[value];
            dfs(next);
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
