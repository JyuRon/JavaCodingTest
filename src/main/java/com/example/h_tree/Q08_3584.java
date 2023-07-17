package com.example.h_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/3584
 */
public class Q08_3584 {
    static FastReader sc = new FastReader();
    static int N, targetA, targetB;
    static ArrayList<Integer>[] graph;
    static int[] parent;


    static void input(){
        N = sc.nextInt();
        graph = new ArrayList[N+1];
        parent = new int[N+1];
        parent[0] = -1;

        for (int i = 1; i <= N ; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            int startNode = sc.nextInt();
            int endNode = sc.nextInt();

            parent[endNode] = startNode;
            graph[startNode].add(endNode);
            graph[endNode].add(startNode);
        }

        targetA = sc.nextInt();
        targetB = sc.nextInt();
    }

    static void func(){
        int rootNode = -1;

        for (int i = 1; i <= N ; i++) {
            if(parent[i] == 0){
                rootNode = i;
                break;
            }
        }
        dfs(rootNode,-1);
    }

    static int dfs(int value, int parent){

        int result = 0;

        if(value == targetA || value == targetB){
            result++;
        }


        for(int next : graph[value]){
            if(next == parent){
                continue;
            }

            result += dfs(next, value);
        }

        if(result == 2){
            System.out.println(value);
            result = 0;
        }

        return result;
    }

    public static void main(String[] args) {
        int testCase = sc.nextInt();

        for (int i = 0; i < testCase; i++) {
            input();
            func();
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
