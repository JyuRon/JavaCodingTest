package com.example.g_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/11724
 */
public class Q09_11724 {

    static FastReader sc = new FastReader();
    static int vertex, edges;
    static Map<Integer, List<Integer>> graph;
    static boolean[] visited;

    static void input(){
        vertex = sc.nextInt();
        edges = sc.nextInt();

        graph = new HashMap<>();

        visited = new boolean[vertex+1];

        // 정점별 리스트 공간 생성
        for (int i = 1; i <= 1000; i++) {
            graph.put(i, new ArrayList<>());
        }

        // 간선 정보 저장
        for (int i = 0; i < edges; i++) {
            int startNode = sc.nextInt();
            int endNode = sc.nextInt();

            graph.get(startNode).add(endNode);
            graph.get(endNode).add(startNode);
        }
    }

    static void func(){
        int result = 0;
        for (int i = 1; i <= vertex; i++) {
            if(!visited[i]){
                bfs(i);
                result++;
            }
        }

        System.out.println(result);
    }

    static void bfs(int node){
        Queue<Integer> Q = new LinkedList<>();
        Q.add(node);
        visited[node] = true;

        while (!Q.isEmpty()){
            int currentVertex = Q.poll();
            for (int i = 0; i < graph.get(currentVertex).size(); i++) {
                int nextVertex = graph.get(currentVertex).get(i);
                if(!visited[nextVertex]){
                    visited[nextVertex] = true;
                    Q.add(nextVertex);
                }
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
