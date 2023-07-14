package com.example.h_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1068
 */
public class Q02_1068 {
    static FastReader sc = new FastReader();
    static int N, rootNode, deleteNode;
    static ArrayList<Integer>[] graph;
    static int[] leaf;

    static void input(){
        N = sc.nextInt();
        graph = new ArrayList[N];
        leaf = new int[N];

        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            int value = sc.nextInt();
            if(value == -1){
                rootNode = i;
            }else{
                graph[value].add(i);
            }
        }

        deleteNode = sc.nextInt();

        for (int i = 0; i < N; i++) {
            if(graph[i].contains(deleteNode)){
                graph[i].remove(graph[i].indexOf(deleteNode));
            }
        }
    }

    static void func(){
        if(deleteNode != rootNode)
            dfs(rootNode);

        System.out.println(leaf[rootNode]);
    }

    static void dfs(int value){

        if(graph[value].size() == 0){
            leaf[value]++;
            return;
        }

        for(int next : graph[value]){
            dfs(next);
            leaf[value] += leaf[next];
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
