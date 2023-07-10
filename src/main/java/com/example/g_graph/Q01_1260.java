package com.example.g_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1260
 */
public class Q01_1260 {

    static FastReader sc = new FastReader();
    static StringBuffer sb = new StringBuffer();
    static int vertex, edges, startNode;
    static List<Integer>[] graph;
    static boolean[] visited;

    static void input(){
        vertex = sc.nextInt();
        edges = sc.nextInt();
        startNode = sc.nextInt();

        // 정점마다 간선을 저장할 수 있는 공간 생성
        graph = new List[vertex+1];
        for (int i = 1; i <= vertex; i++) {
            graph[i] = new ArrayList<>();
        }

        // 방문 여부 체크 공간 생성
        visited = new boolean[vertex+1];


        for (int i = 0; i < edges; i++) {
            int startNode = sc.nextInt();
            int endNode = sc.nextInt();

            graph[startNode].add(endNode);
            graph[endNode].add(startNode);
        }

        for (int i = 1; i <= vertex; i++) {
            Collections.sort(graph[i]);
        }

    }

    static void func(){
        dfs(startNode);
        sb.append("\n");
        bfs();
        System.out.println(sb.toString());
    }

    static void dfs(int value){
        if(!visited[value]){
            visited[value] = true;
            sb.append(value).append(" ");

            for(int i : graph[value]){
                dfs(i);
            }
        }
    }

    static void bfs(){
        for (int i = 1; i <= vertex; i++) {
            visited[i] =false;
        }

        Queue<Integer> needVisit = new LinkedList<>();
        needVisit.add(startNode);

        while (needVisit.size() != 0){
            int node = needVisit.poll();
            if(!visited[node]){
                visited[node] = true;
                sb.append(node).append(" ");
                needVisit.addAll(graph[node]);
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
            }catch(IOException e){
                e.printStackTrace();
            }
            return st.nextToken();
        }

        public int nextInt(){
            return Integer.parseInt(next());
        }
    }
}
