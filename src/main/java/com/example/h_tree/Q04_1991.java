package com.example.h_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1991
 */
public class Q04_1991 {
    static FastReader sc = new FastReader();
    static StringBuffer sb = new StringBuffer();
    static int N;
    static Map<String, List<String>> graph;
    static boolean[] visited;

    static void input(){
        N = sc.nextInt();
        graph = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String node = sc.next();
            String left = sc.next();
            String right = sc.next();

            graph.put(node, List.of(left, right));
        }

    }

    static void func(){
        dfs("A");
        sb.append("\n");

        dfs_middle("A");
        sb.append("\n");

        dfs_last("A");
    }

    // 전위 순회  : 루트 - 왼쪽 - 오른쪽
    static void dfs(String value){
        sb.append(value);

        for(String next : graph.get(value)){
            if(!next.equals(".")){
                dfs(next);
            }
        }
    }

    // 중위 선회 : 왼쪽 - 루트 - 오른쪽
    static void dfs_middle(String value){

        String left = graph.get(value).get(0);
        String right = graph.get(value).get(1);

        if(!left.equals(".")){
            dfs_middle(left);
        }

        sb.append(value);


        if(!right.equals(".")){
            dfs_middle(right);
        }
    }

    // 후위 선회 (왼쪽 - 오른쪽 - 루트)
    static void dfs_last(String value){
        String left = graph.get(value).get(0);
        String right = graph.get(value).get(1);

        if(!left.equals(".")){
            dfs_last(left);
        }

        if(!right.equals(".")){
            dfs_last(right);
        }

        sb.append(value);
    }



    public static void main(String[] args) {
        input();
        func();

        System.out.println(sb.toString());
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
